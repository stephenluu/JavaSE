

/**
 * 变治法 二次幂算法
 * 累乘是关键
 * @author stephenluu
 *
 */
public class PowerUtil {

	public static void main(String[] args) {
		System.out.println(leftPower(2,14));
		System.out.println(rightPower(2,10));
	}
	
	
	static long  leftPower(int a , Integer n){
		
		char[] bytes = Integer.toBinaryString(n).toCharArray();
		
		long t = a;
		for (int i = 1; i < bytes.length; i++) {
			
			t = t*t;
			if (bytes[i] == '1') {
				t *= a;
			}
		}
		
		return t;
	}
	
	
	static long  rightPower(int a , Integer n){
		
		char[] bytes = Integer.toBinaryString(n).toCharArray();
		
		long t = 1;
		long term = a ;
		
		if(bytes[bytes.length-1] == '1')  t = a ; 
			
		for (int i = bytes.length - 2 ; i >=0 ; i--) {
			
			term *= term;
			if (bytes[i] == '1') {
				t  = t*term;
			}
		}
		
		return t;
	}
}
