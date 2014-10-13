package concurrency;

public class DeadLock {

	public static void main(String[] args) {
		final LeftRightDeadLock lock = new LeftRightDeadLock();
		new Thread(){
			@Override
			public void run() {
				lock.leftRight();
			}
		}.start();
		
		new Thread(){
			@Override
			public void run() {
				lock.rightLeft();
			}
		}.start();
	}
}

class LeftRightDeadLock {
	private final Object left = new Object();
	private final Object right = new Object();

	public void leftRight() {
		
		synchronized (left) {
			System.out.println("leftRight got left lock");
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			synchronized (right) {
				System.out.println("leftRight got right lock");
			}
		}
	}

	public void rightLeft() {
		
		synchronized (right) {
			System.out.println("rightLeft got right lock");
			
			synchronized (left) {
				System.out.println("rightLeft got left lock");
			}
		}
	}
}