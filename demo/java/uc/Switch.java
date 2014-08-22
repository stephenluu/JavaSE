package uc;

public class Switch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 30;
		switch(8){
		
			case 8 : k++;
			case 9 : k += 2;
			case 10 : k += 3;
			default : k /= 18;
			
		}
		
		//System.out.println(k);
		
		byte[] b = "dkjfa".getBytes(); 
		for (byte c : b) {
			System.out.println(c);
		}
		
		
		Byte c = Byte.MAX_VALUE;
		short s = Short.MAX_VALUE;
		int i = Integer.MAX_VALUE;
		long l = Long.MAX_VALUE;
		
		c = (byte) (129);
		
		l = (long)(Integer.MAX_VALUE+1);
		
		System.out.println(c+1);
		System.out.println(s+1);
		System.out.println(i+1);
		System.out.println(l+1);
	}

}
