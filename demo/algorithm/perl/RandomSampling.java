package perl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Floyd 随机取样算法 等概率
 * @author stephenluu
 *
 */
public class RandomSampling {

	private static final Random random = new Random();
	//private static Set<Integer> set ;
	
	public static void main(String[] args) {

		Set<Integer> set = sample(5,10);
		System.out.print("sample1: ");
		for (Integer integer : set) {
			System.out.print(integer+" ");
		}
		
		
		set = sample2(5,10);
		System.out.print("\nsample2: ");
		for (Integer integer : set) {
			System.out.print(integer+" ");
		}
		
		System.out.print("\nraw random: ");
		for (int i = 0; i < 5; i++) {
			System.out.print(new Random().nextInt(10)+1+" ");
		}
			
		
	}
	
	/**
	 * Floyd 1
	 * @param m
	 * @param n
	 * @return
	 */
	public static Set<Integer> sample(int m, int n){
		
		if ( m == 0 ){
			return new HashSet<Integer>();
		}
		
		Set<Integer> set = sample(m-1,n-1);
		int t = random.nextInt(n)+1;
		
		if (!set.contains(t)) {
			set.add(t);
		}else set.add(n);
		
		return set;
		
	}
	
	/**
	 * Floyd 2
	 * @param m
	 * @param n
	 * @return
	 */
	public static Set<Integer> sample2 (int m, int n){
		
		Set<Integer> set = new HashSet<Integer>();
		
		int t ;
		for (int i = n-m+1; i <= n; i++) {
			
			t = random.nextInt(i)+1;
			
			if (!set.contains(t)) {
				set.add(t);
			}else {
				set.add(i);
			}
		}
		
		return set;
	}

}
