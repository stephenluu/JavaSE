package concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class BoundedHashSet<T> {

	public static void main(String[] args) throws InterruptedException {
		final BoundedHashSet<Integer> bset = new BoundedHashSet<Integer>(5);
		

		Thread t0 = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					try {
						bset.add(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("added " + i + " set: "+bset.set);
				}
			}
		};
		t0.start();
		
		Thread.sleep(500);
		
		Thread t = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 8; i++) {
					bset.remove(i);
					System.out.println("removed " + i+ " set: "+bset.set);
				}
			}
		};
		t.start();
		
	}
	
	private final Set<T> set;
	private final Semaphore sem;
	
	public BoundedHashSet(int bound){
		this.set = Collections.synchronizedSet(new HashSet<T>());
		this.sem = new Semaphore(bound);
	}
	
	public boolean add (T t) throws InterruptedException  {
		sem.acquire();
		boolean wasAdded = false;
		
		try {
			wasAdded = set.add(t);
			return wasAdded;
		} finally{
			if(!wasAdded)
				sem.release();
		}
	}
	
	public boolean remove(T t)  {
		boolean wasRemoved = set.remove(t);
		if(wasRemoved)
			sem.release();
		
		return wasRemoved;
	}

}
