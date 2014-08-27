package concurrency;

/**
 * 不可变类
 * @author luliuyu
 *
 */
public class Point {

	private final int x, y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new Point(3,4).x);
	
	}
}
