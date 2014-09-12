package concurrency.studentDemo;

import java.util.concurrent.BlockingQueue;

public class MyThead implements Runnable {

	private final BlockingQueue<Student> quque;
	
	public MyThead(BlockingQueue<Student> quque) {
		this.quque = quque;
	}


	@Override
	public void run() {
		while(true)
			try {
				printStudent();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	private void  printStudent() throws InterruptedException{
		
	}

}
