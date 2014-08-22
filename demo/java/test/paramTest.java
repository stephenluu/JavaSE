package test;

public class paramTest {

	/**
	 * 
	 * @param args
	 * 引用传值
	 */
	public static void main(String[] args) {

		int[] b = new int[5] ;
		foo(b );
		System.out.println(b[0]);
		
		String name = "luliuyu";
		change(name);
		System.out.println(name);
		
		String[] list = new String[5];
		change(list);
		System.out.println(list[0]);
		
		Student student = new Student();
		change(student);
		System.out.println(student.name);
	}
	
	private static void change(Student student) {

		student.name = "luliyu";
	}

	static void foo(int[] b){
		
		b[0] =  1;
	}
	
	static void change(String name){
		
		name = "stephen";
	}
	
	static void change(String[] list){
		
		list[0] = "hello";
	}

}

class Student{
	
	String name = "stephen";
}
