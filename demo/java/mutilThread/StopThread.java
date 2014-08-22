package mutilThread;

public class StopThread {

	private static  boolean stopRequested ;//加volatile 会让其他线程看得见
	
	public static void main(String[] args) {

		Thread bgThread = new Thread(new Runnable(){
			@Override
			public void run() {
				int i = 0;
				while(!stopRequested)
					i++;
				
			}
		});
		
		bgThread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		stopRequested = true;
	}

}
