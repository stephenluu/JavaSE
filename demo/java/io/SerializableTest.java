package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Person p1 = new Person(20, "zhangsan", 4.55);
		Person p2 = new Person(50, "lisi", 4.67);
		Person p3 = new Person(10, "wangwu", 17.78);
		
		FileOutputStream fos = new FileOutputStream("person.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(p1);
		oos.writeObject(p2);
		oos.writeObject(p3);
		
		oos.close();
		
		FileInputStream fis = new FileInputStream("person.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Person p = null;
		for (int i = 0; i < 3; i++) {
			
			p = (Person) ois.readObject();
			System.out.println(p.name+","+p.age+","+p.height);
		}
		
		ois.close();
	}

}


class Person implements Serializable
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 18825193908L;

	int age;

	String name;

	double height;

	public Person(int age, String name, double height)
	{
		this.age = age;
		this.name = name;
		this.height = height;
	}
}