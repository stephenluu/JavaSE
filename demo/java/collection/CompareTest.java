package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CompareTest {

	public static void main(String[] args) {

		Integer[] a = {1,3,5,2,63,46,56,45};
		Arrays.sort(a);
		
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, a);
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
		for (int i : a) {
			System.out.println(i);
		}
	}

}
