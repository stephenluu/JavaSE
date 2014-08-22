package test;

public class tryReturn {

	public static void main(String[] args) {

		System.out.println(test());
	}
	
	static int test(){
		int i = 0;
		
		try{
			i++;
			return i;
		}
		finally{
			i++;
			//return i;
		}
	}

}
