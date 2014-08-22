package feature;

import java.util.Arrays;
import java.util.List;

public class ForTest {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,5,6,3,7,8,2,4,5,6,3,7,8,2,5,6,3,7,8,2,5,6,3,7,8,2,5,6,3,7,8,2);

		long time0 = System.nanoTime();
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += i;
		}
		System.out.println(sum);
		time0 = System.nanoTime()-time0;
		
		long time1 = System.nanoTime();
		sum = 0;
		for (int i = 0,length = list.size(); i < length; i++) {
			sum += i;
		}
		System.out.println(sum);
		time1 = System.nanoTime()-time1;
		
		System.out.println("速度，1是2的 " + time0/time1+"倍");
		
		long time2 = System.nanoTime();
		Integer s = Integer.valueOf(0);
		for (Integer integer : list) {
			s += integer;
		}
		time2 = System.nanoTime()-time2;
		System.out.println("速度，1是3的 " + time0/time2+"倍");
	}

}
