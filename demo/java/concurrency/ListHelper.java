package concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 客户端加锁
 * @author luliuyu
 *
 * @param <E>
 */
public class ListHelper<E> {

	public List<E> list = Collections.synchronizedList(new ArrayList<E>());
	
	/**
	 * non-thread-safe
	 * 这个锁是ListHelper的，不是list上的；
	 * eg. list 在遍历的时候list也可以add
	 * 如果是可变对象，对它加锁就好了
	 * @param e
	 * @return
	 */
	/*public synchronized boolean putIfAbsent(E e){
		boolean absent = !list.contains(e);
		if(absent)
			list.add(e);
		return absent;
	}*/
	
	
	/**
	 * non-thread-safe
	 * 这个锁是list上的
	 * @param e
	 * @return
	 */
	public  boolean putIfAbsent (E e)  {
		
		synchronized (list) {
			boolean absent = !list.contains(e);
			if(absent)
				list.add(e);
			return absent;
		}
	}
}
