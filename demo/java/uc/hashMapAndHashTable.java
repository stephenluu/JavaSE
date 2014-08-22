package uc;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class hashMapAndHashTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	    Map<String,String> map = new HashMap<String,String>();
	    map.put(null, null);
		
		Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
		numbers.put("one", 1);
		numbers.put("two", 2);
		numbers.put("three", 3);
		//numbers.put(null, null);
		//System.out.println(Integer.toBinaryString(0x0f & 0x2));
		
		
		ok:
			for(int i=0;i<10;i++)	{
				for(int j=0;j<10;j++)		{
					System.out.println("i=" + i + ",j="+ j);
					if(j == 5) break ok;
				}
			}

	}

}
