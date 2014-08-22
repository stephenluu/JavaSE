package c04;

public class Divider {

	public static void main(String[] args) {
		int a[] = {1,6,8,9,55,56,78};
		System.out.println(recursionBinarySearch(a, 1));
	}
	
	/**
	 * 二分查找
	 * 关键点 		条件 l <= r 	折半 		有序
	 * @param a
	 * @param k
	 * @return
	 */
	static int binarySearch(int a[] , int k){
		
		int len = a.length;
		int l = 0;
		int r = len - 1;
		int m = 0;
		
		while (l <= r){
			
			 m = (l + r)/2;
			 
			if (k == a[m])
				return m;
			else if (k < a[m])
				r = m - 1;
			else
				r = m + 1;
		}
		
		return -1;
	}
	
	
	/**
	 * 递归二分查找
	 * @param a 有序数组
	 * @param k
	 * @return
	 */
	static int recursionBinarySearch(int a[] , int k){
		
		return helper(a,k,0,a.length-1);
	}
	
	static int helper(int a[] , int k ,int l,int r){
		
		if (r < l) return -1;
		
		int m = (l + r) / 2;
		
		if (k == a[m])
			return m + 1;
		else if (k < a[m])
			return helper(a, k, l, m - 1);
		else
			return helper(a, k, m + 1, r);
	}
}
