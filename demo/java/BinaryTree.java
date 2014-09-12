

import java.util.Stack;

public class BinaryTree {

	public static void main(String[] args) {

		// 构造树 T
		TreeNode T = new TreeNode(1);
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(6);
		TreeNode t6 = new TreeNode(7);

		T.left = t1;
		T.right = t2;
		t1.left = t3;
		t1.right = t4;
		t2.left = t5;
		t2.right = t6;

		//System.out.println("Hight = " + hight(T));
		int d = DistByPreorderTraverval(T);
		System.out.println(d);

	}



	/**
	 * 
	 * 
	 * @param T
	 */
	public static int DistByPreorderTraverval(TreeNode T) {

		if (T == null)
			throw new NullPointerException("树不能为空！");
		
		int max = T.val;
		int min = max;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(T);

		//迭代式先序遍历
		while (!stack.isEmpty()) {

			TreeNode curr = stack.pop();
			
			//求最大值 最小值
			if(curr.val >  max)
				max = curr.val;
			else if (curr.val < min)
				min = curr.val;

			if (curr.right != null)
				stack.push(curr.right);
			if (curr.left != null)
				stack.push(curr.left);
		}
		
		int dist = max - min;
		if( dist < 0)
			dist = -1 * dist;
		
		return dist;
	}

	

}



class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int x){
		
		val = x;
		left = null;
		right = null;
	}
}
