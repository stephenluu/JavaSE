package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RunTests {

	public static void main(String[] args) throws  Exception {

		Class<?> clazz = Class.forName("reflection.Student");
		
		for (Field f : clazz.getDeclaredFields()) {
			System.out.println(f);
		}
		System.out.println("以上是域\n");
		
		for (Constructor<?> c : clazz.getDeclaredConstructors()) {
			System.out.println(c);
		}
		System.out.println("以上是构造器\n");
		
		for (Method m : clazz.getDeclaredMethods()) {
			if(m.isAnnotationPresent(Test.class)){
				m.invoke(null, null);
				System.out.println("VALID @Test: "+m);
			}else 	System.out.println("INVALID @Test: "+m);
				
		}
		System.out.println("以上是方法\n");
	}

}
