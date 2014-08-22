package test;

public class TempTest {

	static String str = "";
	public static void main(String[] args) {

		Thread t = null;
		for (int i = 0;i<4;i++) {
			t = new MyThread();
			t.start();
		}
	}
	
	public static  void print(int i){
		
		str = Thread.currentThread().getName()+" "+i;
		System.out.println(str);
		System.out.println(str);
		System.out.println(str);
		System.out.println(str);
		System.out.println("----------");
	}

}

class MyThread extends Thread{
	
	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			
			TempTest.print(i);
			
		}
	}
}