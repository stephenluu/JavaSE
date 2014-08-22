package mutilThread;

import java.io.File;

/**
 * 多线程打印文件夹下的文件名
 *
 */
public class Client {

	public static void main(String[] args) {

		File folder = new File("C:/test");

		if (folder.isDirectory()) {
			
			File[] files = folder.listFiles();
			if(files != null)
				FileContainer.setFiles(files);
			else System.out.println("空文件夹！");
		}

		Thread t = null;
		FileContainer fc =  new FileContainer();
		for (int i = 0; i < 5; i++) {

			t = new ReadThread(fc);
			System.out.println(t.getName() + " started.");
			t.start();
			
		}
	}
	
}
