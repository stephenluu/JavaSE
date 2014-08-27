package concurrency.diskSearch;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Client {

	private final static int BOUND = 100;
	private final static File folder = new File("e:/");
	private final static File[] roots = folder.listFiles();
	private final static int N_CONSUMERS = 6;
	
	public static void main(String[] args) {

		BlockingQueue<File> queue = new LinkedBlockingQueue<File>(BOUND);
		
		FileFilter fileFilter = new FileFilter(){
			@Override
			public boolean accept(File pathname) {
				return true;
			}
		};
		
		for (File root : roots) {
			new Thread(new FileCrawler(queue, fileFilter, root)).start();
		}
		
		for (int i = 0; i < N_CONSUMERS; i++) {
			new Thread(new Indexer(queue)).start();
		}
	}

}
