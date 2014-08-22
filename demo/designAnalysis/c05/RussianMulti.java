package c05;

public class RussianMulti {

	public static void main(String[] args) {

		System.out.println(russianMulti(10163, 229591));
	}
	/**
	 * 俄国乘法
	 */
	static long russianMulti(long n, long m) {

		long t = 0;
		
		while (n != 1) {

			if (n % 2 == 0) {

				n = n >> 1;
			} else {
				
				n = (n - 1) >> 1;
				t += m;
			}

			m = m << 1;
		}

		return m + t;
	}

}
