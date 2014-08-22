package c02;

public class Fibonacci {

	public static void main(String[] args) {

		System.out.println(fibonacci(10));
		System.out.println(fib(10));
	}
	
	
	/**
	 * 递归式 重复计算效率差
	 * @param n
	 * @return
	 */
	static long fibonacci(int n){
		
		if (n <= 1 ) return n;
		
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	/**
	 * 迭代式 效率 n
	 * @param n
	 * @return
	 */
	static long fib (int n) {
		
		if (n <= 1  ) return n;
		
		long f1 = 0 ;
		long f2 = 1 ;
		long sum = 0;
		
		for (int i = 2; i <= n; i++) {
			
			sum = f1 + f2;
			f1 = f2;
			f2 = sum;
		}
		
		return sum;
	}
}
