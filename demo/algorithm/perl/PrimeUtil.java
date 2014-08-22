package perl;

/**
 * 素数算法的速度差异
 * @author luliuyu
 *
 */
public class PrimeUtil {

	public static void main(String[] args) {

		long preTime = System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			if (prime(i))
				;
			// System.out.println(i);
		}

		long time = System.currentTimeMillis() - preTime;
		System.out.println("prime used time " + time + " ms");
		

		preTime = System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			if (prime2(i))
				;
			// System.out.println(i);
		}

		time = System.currentTimeMillis() - preTime;
		System.out.println("prime2 used time " + time + " ms");
		
		
		preTime = System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			if (prime3(i))
				;
			// System.out.println(i);
		}

		time = System.currentTimeMillis() - preTime;
		System.out.println("prime3 used time " + time + " ms");

	}

	public static boolean prime(int n) {

		if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0)
			return n == 2 || n == 3 || n == 5;

		for (int i = 7; i * i < n; i += 2) {

			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static boolean prime2(int n) {

		for (int i = 2; i * i < n; i++) {

			if (n % i == 0)
				return false;
		}

		return true;
	}

	public static boolean prime3(int n) {

		for (int i = 2; i < n; i++) {

			if (n % i == 0)
				return false;
		}

		return true;
	}
}
