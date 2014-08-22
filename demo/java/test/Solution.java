package test;

public class Solution {

	public static void main(String[] args) {
		

		 for (double i = 0.1; i < 10; i += 0.1) {
			System.out.println(i);
		}
		//System.out.println(reverseWords(" f    hello     "));
	}

	public static String reverseWords(String s) {

		s = s.trim();
		if (!s.contains(" "))
			return s;
		String[] subStr = s.split(" +");
		StringBuffer sb = new StringBuffer();

		for (int i = subStr.length - 1; i >= 0; i--) {
			sb.append(subStr[i]);
			sb.append(" ");
		}

		return sb.toString().trim();

	}
}
