package mutilThread;

import java.io.File;

public class ReadThread extends Thread{

	private boolean flag = true; // 线程运行标志，true 线程则一直运行，false则 while 循环停止，run
								// 执行完毕，线程自然结束
	private FileContainer fileContainer ;

	public ReadThread(FileContainer fileContainer) {
		
		this.fileContainer = fileContainer;
	}
	
	
	@Override
	public void run() {

		while (flag) {
			
			File file = this.fileContainer.readCurrFile();
			if (file != null) {
				System.out.println(file.toString() + " by "
						+ Thread.currentThread().getName());
				
				// 实际需求会有一些IO操作，如修改再保存之类,用计算来睡眠模拟
				try
				{
					Thread.sleep((long)(Math.random() * 1000));
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}else {
				stopThread();//停止线程
			}
		}
	}

	private void stopThread() {

		this.flag = false;
		System.out.println("finished and stopped by "
				+ Thread.currentThread().getName());
	}
}
