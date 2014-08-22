package javaSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class JavaSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Collections.sort List
		List<String> list = new ArrayList<String>();
		list.add("v");
		list.add("a");
		list.add("b");
		
		for (String string : list) {
			System.out.println(string);
		}
		Collections.sort(list);
//		Collections.sort(list, new Comparator<String>() {
//			public int compare(String o1, String o2) {
//				return o1.toString().compareTo(o2.toString());
//			}
//		});
		
		for (String string : list) {
			System.out.println(string);
		}
		
		
		// Arrays.sort
		int[] days = {1,3,5,6,7,2,4};
		
		Arrays.sort(days);
		for (int i : days) {
			System.out.println(i);
		}
		
		
		// TreeSet
		Set<String> sortedSet = new TreeSet<String>(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.toString().compareTo(o2.toString());
			}
		});
		Set<String> unsortedSet = new HashSet<String>();
		unsortedSet.add("y");
		unsortedSet.add("t");
		unsortedSet.add("b");
		sortedSet.addAll(unsortedSet );

		for (String string : unsortedSet) {
			System.out.println(string);
		}
		
		for (String string : sortedSet) {
			System.out.println(string);
		}
		
		
		// TreeMap - using String.CASE_INSENSITIVE_ORDER which is a Comparator that orders Strings by compareToIgnoreCase
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		Map<String,Integer> unsortedMap = null;
		sortedMap.putAll(unsortedMap);
	}
	
	

}
