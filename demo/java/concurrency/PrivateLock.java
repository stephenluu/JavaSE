package concurrency;

/**
 * 
 * @author luliuyu
 *
 */
public class PrivateLock {

	private final Object myLock = new Object();
	
	void foo(){
		synchronized (myLock){
			System.out.println(3);
		}
	}
}
