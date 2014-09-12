package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorTest {

	private static final Executor exec = Executors.newFixedThreadPool(4); 
	public static void main(String[] args) {
		Runnable command = new Runnable(){

			@Override
			public void run() {
				while(true){
					System.out.println("hello world "+ Thread.currentThread().getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
					
			}
			
		};
		exec.execute(command);
		exec.execute(command);
	}

}
