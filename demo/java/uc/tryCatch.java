package uc;

public class tryCatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(test());
		

	}
	
	static int test(){
		
	int i = 0;
		
		try {
			i++;
			return i;
		} finally{
			
			i++;
			System.out.println("finanlly:"+i);
			
			//return 之前把操作栈顶的值取出，返回
			return i;
		}
	}

}
