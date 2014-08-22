package test;

public class Round {
	public static void main(String[] args) {
		
		System.out.println(Math.round(11.5));
		System.out.println(Math.round(-11.4));
		System.out.println(Math.floor(-11.4+0.5));
		
		System.out.println(test());
		

	}
	
	static boolean test(){
		int  x = 1;
		return x==1?true:false;
	}
}
