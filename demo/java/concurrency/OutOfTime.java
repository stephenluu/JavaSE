package concurrency;

import java.util.Timer;
import java.util.TimerTask;

public class OutOfTime {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new ThrowTask(), 1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("after 1");
		timer.schedule(new ThrowTask(), 1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("after 2");
	}

	static class ThrowTask extends TimerTask {
		public void run() {
			throw new RuntimeException();
		}
	}
}
