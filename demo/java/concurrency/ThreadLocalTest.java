package concurrency;

public class ThreadLocalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(){
				@Override
				public void run() {
					Student.id = Thread.currentThread().getName()+" "+Thread.currentThread().getId();
					Student.name.set(Thread.currentThread().getName());
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(Student.name.get());
					System.out.println(Student.id);
				}
			};
			t.start();
			
		}

	}

}

class Student {
	
	public  static String id;
	public  static  ThreadLocal<String> name = new ThreadLocal<String>();//需要容器来装，所以new

}
