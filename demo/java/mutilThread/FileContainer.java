package mutilThread;

import java.io.File;

public class FileContainer {

	private static  File[] files ;//文件数组
	private static int curr = 0; //文件数组的游标，增加时需考虑线程安全
	
	
	
	public static File[] getFiles() {
		return files;
	}
	public static void setFiles(File[] files) {
		FileContainer.files = files;
	}
	public static int getCurr() {
		return curr;
	}
	public static void setCurr(int curr) {
		FileContainer.curr = curr;
	}
	
	
	/**
	 * synchronized，此方法互斥访问　
	 * @return 一个文件
	 */
	public synchronized static File  readCurrFile() {
	
		// 游标越界则停止
		if (curr > files.length - 1) {
			return null;
		}

		System.out.println(curr + " by " + Thread.currentThread().getName());
			File file = files[curr];
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		setCurr(++curr); //游标+1

		return file;
	}
	
/*	public  File  readCurrFile() {
		
		synchronized(this){
			// 游标越界则停止
			if (curr > files.length - 1) {
				return null;
			}

			System.out.println(curr + " by " + Thread.currentThread().getName());
			File file = files[curr];
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setCurr(++curr); //游标+1

			return file;
		}
		
	}*/
	
}
