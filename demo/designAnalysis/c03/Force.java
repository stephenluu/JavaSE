package c03;

public class Force {

	public static void main(String[] args) {

//		int a[] = {5,5,3,6,8};
//		System.out.println(sequentialSearch2(a,9));
		
		System.out.println(stringMatch("stephenluu","luu"));
	}

	/**
	 * 顺序查找
	 * @param a
	 * @param k
	 * @return
	 */
	static int sequentialSearch2(int a[], int k) {

		a[a.length - 1] = k;

		int i = 0;
		while (a[i] != k)
			i++;

		if (i < a.length - 1)
			return i+1;
		else
			return -1;
	}
	
	
	/**
	 * 蛮力字符串匹配
	 * 注意：i < len - pLen +1
	 * @param s
	 * @param p
	 * @return
	 */
	static int stringMatch(String s, String p){
		
		int len = s.length(); 
		int pLen = p.length();
														
		for (int i = 0; i < len - pLen +1; i++) {
			
			if (s.substring(i, i+pLen).equals(p)){
				
				return i+1;
			}
		}
		
		return -1;
	} 

}
