package test;

import java.util.Arrays;

public class TempTest {


	public static void main(String[] args) {
		
		int[] pages = new int[20];
		int currPage = 3;
		int totalPage = 100;
		
		
		int start = currPage - 10;
		if (start < 1)
			start = 1;
		int end = currPage + 9;
		
		if (end > totalPage)
			start -= end - totalPage ;
		
		for (int i = 0; i < 20; i++) {
			pages[i] = start++; 
		}
		System.out.println(Arrays.asList(pages));
	}

}

