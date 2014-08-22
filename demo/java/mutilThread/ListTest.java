package mutilThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListTest {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		executor.execute(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println(3);
				}
					
			}
			
		});
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		executor.shutdownNow();
		System.out.println("tried shutdown");
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(5);
		list.add(5);
		list.add(5);
		
		//throw new AssertionError("stop");
		
		/*for (Integer integer : list) {
			
			System.out.println(integer);
			if (integer == 5)
			list.remove(integer);
		}*/
		/*int[] a = {1,2,3,5,6};
		List<int[]> list = Arrays.asList(a);
		
		for (int[] is : list) {
			
			for (int i : is) {
				System.out.println(i);
			}
		}*/
		
		
	}

}
