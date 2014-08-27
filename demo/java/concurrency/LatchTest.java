package concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁 可以让若干线程同时竞争执行，也可以等待这些线程全部执行后做触发事件
 * @author luliuyu
 *
 */
public class LatchTest {
	
	private final static int N_THREADS = 10;

	public static void main(String[] args) throws InterruptedException {

		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(N_THREADS);
		
		for (int i = 0; i < N_THREADS; i++) {
			new Thread(){
				public void run() {
					try {
						startGate.await();
						for (int j = 0; j < 10; j++) {
							System.out.println(Thread.currentThread().getName()+" "+j);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally{
						endGate.countDown();
					}
				};
			}.start();
		}
		
		startGate.countDown();
		long start = System.nanoTime();
		endGate.await();
		long time = System.nanoTime() - start;
		System.out.println("took "+time+"ms");
	}

}
