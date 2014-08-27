package concurrency.diskSearch;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class Indexer implements Runnable {

	private final BlockingQueue<File> fileQueue;
	
	public Indexer(BlockingQueue<File> fileQueue) {
		super();
		this.fileQueue = fileQueue;
	}

	@Override
	public void run() {
		while(true){
			
			try {
				indexFile(fileQueue.take());
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}



	private void indexFile(File take) {
		System.out.println("indexed "+take);
	}

}
