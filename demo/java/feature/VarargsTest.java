package feature;

public class VarargsTest {

	public static void main(String[] args) {

		System.out.println(sum(1,2,3,5));
		System.out.println(sum());
	}
	
	static int sum(int... args){
		int sum =  0;
		for (int i : args) {
			sum += i;
		}
		return sum;
	}

}
