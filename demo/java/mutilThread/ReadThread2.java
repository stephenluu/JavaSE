package mutilThread;

import java.io.File;

public class ReadThread2 implements Runnable {

	private boolean flag = true; // 线程运行标志，true 线程则一直运行，false则 while 循环停止，run
								// 执行完毕，线程自然结束

	@Override
	public void run() {

		while (flag) {
			File file = getFile();
			if (file != null) {
//				System.out.println(file.toString() + " by "
//						+ Thread.currentThread().getName());
				
				// 实际需求会有一些IO操作，如修改再保存之类,用计算来睡眠模拟
//				try
//				{
//					Thread.sleep((long)(Math.random() * 1000));
//				}
//				catch (InterruptedException e)
//				{
//					e.printStackTrace();
//				}
			}
		}
	}

	/**
	 * synchronized，此方法互斥访问　
	 * @return 一个文件
	 */
	private synchronized File getFile() {

		int curr = Client2.getCurr();
		File[] files = Client2.getFiles();

		// 游标越界则停止
		if (curr > files.length - 1) {

			System.out.println("finished by "
					+ Thread.currentThread().getName());
			stopThread();// 停止线程
			return null;
		}

		System.out.println(curr + " by " + Thread.currentThread().getName());
		File file = files[curr];
		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Client2.setCurr(++curr);

		return file;
	}

	private void stopThread() {

		this.flag = false;
	}
}
