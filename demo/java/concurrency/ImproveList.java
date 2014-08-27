package concurrency;

import java.util.List;

/**
 * 组合
 * @author luliuyu
 *
 * @param <T>
 */
public class ImproveList <T> /*implements List<T>*/{

	private final List<T> list;

	public ImproveList(List<T> list ) 
	{
		this.list = list;
	}
	
	public synchronized boolean putIfAbsent(T e){
		boolean absent = !list.contains(e);
		if(absent)
			list.add(e);
		return absent;
	}
	
	
	
}
