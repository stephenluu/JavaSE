package concurrency;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HiddenIterator {
	private final Set<Integer> set = new HashSet<Integer>();

	public synchronized void add(Integer i) {
		set.add(i);
	}

	public synchronized void remove(Integer i) {
		set.remove(i);
	}

	public void addTenThings() {
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int x = r.nextInt();
			System.out.println(x);
			add(x);
		}

		System.out.println("DEBUG: added ten elements to " + set);
	}

	public static void main(String[] args) {

		final HiddenIterator hi = new HiddenIterator();

		Runnable r = new Runnable() {

			@Override
			public void run() {
				hi.addTenThings();
			}

		};

		//两个线程一起给set 加元素
		Thread t = new Thread(r);
		Thread t1 = new Thread(r);
		t.start();
		t1.start();
	}
}
