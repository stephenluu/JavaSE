package clone;

public class CloneTest1 {

	public static void main(String[] args) throws CloneNotSupportedException {

		Student student = new Student();
		student.setName("stephen");
		student.setAge(22);
		
		Student student2 = (Student) student.clone();
		
		System.out.println(student.getName());
		System.out.println(student2.getName());
		
	}
	
}


class Student implements Cloneable{

	private int age ;
	private String name;
	
	
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}

