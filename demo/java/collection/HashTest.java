package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Map;

public class HashTest {

	public static void main(String[] args) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("a", "a");
		map.put("a", "b");
		
		System.out.println(map.get("a"));
		
		LinkedHashSet<Object> linkedSet = new LinkedHashSet<Object>();
		
		
		Hashtable table = new Hashtable();
		
		HashSet set = new HashSet();
	}

}
