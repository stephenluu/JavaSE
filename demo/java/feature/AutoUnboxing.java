package feature;

public class AutoUnboxing {

	public static void main(String[] args) {

		
		Long sum = 0L;
		
		long t0 = System.currentTimeMillis();
		for (long i = 0; i < Integer.MAX_VALUE/2; i++) {
			sum += i;
		}
		t0 = System.currentTimeMillis() - t0;
		System.out.println("Unboxing Boxing took "+ t0 +" sum = "+ sum);
		
		
		sum = 0L;
		long t1 = System.currentTimeMillis();
		for (Long i = Long.valueOf(0); i < Integer.MAX_VALUE/2; i++) {
			sum += i;
		}
		t1 = System.currentTimeMillis() - t1;
		System.out.println("packaging took "+ t1 +" sum = "+ sum);
		
		
		long s = 0L;
		long t2 = System.currentTimeMillis();
		for (long i = 0L; i < Integer.MAX_VALUE/2; i++) {
			s += i;
		}
		t2 = System.currentTimeMillis() - t2;
		System.out.println("prime took "+ t2 +" sum = "+ s);
		
	}

}
