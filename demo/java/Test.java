import java.util.HashMap;


public class Test {

	public static void main(String[] args) {

	}
	
	/**
	 * 最长连续字母序列的长度
	 * 使用 动态规划 解决
	 * 建立二维表，query 为竖，text 为横 ， 值为0或1，1代表相同， 对角线最多1的就是最长序列；
	 * O(n*n)
	 * @param query
	 * @param text
	 * @return
	 */
	 public int longestConsecutive(String query,String text) {
		
		 if (query == null || text == null)
			 return 0;
		 
		 int qLength = query.length();
		 int textLength = text.length();
		 
		int[][] table = new int[qLength][textLength]; 
		
		//初始化
		for (int i = 0;i < qLength;i++) {
			for (int j = 0; j < textLength; j++) {
				if (query.charAt(i) == text.charAt(j))
					table[i][j] = 1;
			}
			
		}
		 
		
		//TODO 求最长对角线
		int maxLength = 0;
		
		
		
		return maxLength;
		 
	}
	 
}
