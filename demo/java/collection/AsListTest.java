package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AsListTest {

	public static void main(String[] args) {

		setList();
	}

	static void asList(){
		
		int a = 5;
		int[] b = {0,1,2,3,4,5,6,7,8};
		Integer[] c =  {0,1,2,3,4,5,6,7,8};
		
		List<Integer> alist = Arrays.asList(a);
		List<int[]> blist = Arrays.asList(b);
		List<Integer> clist = Arrays.asList(c);
		
		
		System.out.println(alist.toString());
		
		System.out.println(Arrays.toString(b));
		System.out.println(blist.toString());
		ArrayList<Integer> b2list = new ArrayList<Integer>();
		for (Integer integer : b) {
			b2list.add(integer);
		}
		System.out.println("b2list: "+b2list);
		
		for (int i = 0 ; i < b2list.size(); i+=2) {
			
			b2list.remove(i);
			System.out.println("remove index -i="+ i + " b2list: "+b2list);
		}
		System.out.println("removed b2list: "+ b2list);
		
		System.out.println(clist.toString());
	}
	
	static void setList(){
		
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		// 0 1 2 3 4 5
		for (int i = 2; i < 6; i++) {
			set.add(i);
			list.add(i);
		}
		
		//list.remove((Integer)2);
		//System.out.println("contains int 3 ? :"+list.contains(3));
		
		for (int i = 0; i < 3; i++) {
			set.remove(i);
			list.remove(i);
		}
		
		System.out.println("removed set: "+set.toString());
		System.out.println("removed list: "+list.toString());
		
		//for 循环每次remove后都是一个新的状态,按index remove 注意
//		for (int/*Integer*/ i = 0; i < 3; i++) {
//			set.remove(i);
//			System.out.println("remove set i = "+i+" set: "+set.toString());
//			
//			list.remove(i);
//			System.out.println("remove list i = "+i+" list: "+list.toString());
//		}
	}
}
