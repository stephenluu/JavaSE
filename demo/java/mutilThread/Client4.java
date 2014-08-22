package mutilThread;

import java.io.File;

/**
 * 多线程打印文件夹下的文件名
 *
 */
public class Client4 {

	private static  File[] files ;//文件数组
	private static int curr = 0; //文件数组的游标，增加时需考虑线程安全
	

	public static void main(String[] args) {

		File folder = new File("C:/test");

		if (folder.isDirectory()) {
			files = folder.listFiles();

		}

		Thread t = null;
		for (int i = 0; i < 5; i++) {

			t = new Thread(new ReadThread4());
			t.start();
			System.out.println(t.getName() + " started.");
		}
	}
	
	
	// getter/setter
	public static int getCurr() {
		return curr;
	}

	public static void setCurr(int curr) {
		Client4.curr = curr;
	}

	public static File[] getFiles() {
		return files;
	}
}