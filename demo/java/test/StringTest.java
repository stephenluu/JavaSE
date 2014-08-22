package test;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		String str = "0123456789";
		
		String sub = str.substring(0, 10);
		char c1 = str.charAt(0);
		int index = str.indexOf("122");
		System.out.println(str);
		char[] array = str.toCharArray();
		System.out.println(array);
		
		str = Arrays.toString(array);
		System.out.println(str);

	}

}
