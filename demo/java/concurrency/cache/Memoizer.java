package concurrency.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 高效并发缓存
 * @author luliuyu
 *
 * @param <A>
 * @param <V>
 */
public class Memoizer<A,V> implements Computable<A,V> {

	private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<A,Future<V>>();
	private final Computable<A,V> c;
	
	
	public Memoizer(Computable<A, V> c) {
		super();
		this.c = c;
	}


	@Override
	public V compute(final A arg) throws InterruptedException, ExecutionException {
		while(true){
			Future<V> f = cache.get(arg);
			if(f == null){
				Callable<V> eval = new Callable<V>() {

					@Override
					public V call() throws Exception {
						return c.compute(arg);
					}};
				FutureTask<V> ft = new FutureTask<V>(eval);
				f = cache.putIfAbsent(arg, ft);
				if (f == null){
					f = ft;
					ft.run();
				}
			}
			
			return f.get();
		}
	}

}
