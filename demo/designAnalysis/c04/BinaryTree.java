package c04;

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

		System.out.println("Hight = " + hight(T));
		preorderTraverval(T);
		System.out.print("\n 中序遍历：");
		inorderTraverval(T);

		System.out.print("\n 后序遍历：");
		postorderTraverval(T);

	}

	/**
	 * 二叉树的高度 实现：递归
	 * 
	 * @param tn
	 * @return
	 */
	static int hight(TreeNode tn) {

		if (tn == null)
			return 0;

		return Math.max(hight(tn.left), hight(tn.right)) + 1;
	}

	/**
	 * 先序遍历
	 * 
	 * @param T
	 */
	static void preorderTraverval(TreeNode T) {

		if (T == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(T);

		while (!stack.isEmpty()) {

			TreeNode curr = stack.pop();
			System.out.print(curr.val + "-");

			if (curr.right != null)
				stack.push(curr.right);
			if (curr.left != null)
				stack.push(curr.left);
		}
	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 */
	static void inorderTraverval(TreeNode root) {

		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode p = root;

		while (!stack.isEmpty()) {

			if (p.left != null) {

				stack.push(p.left);
				p = p.left;
			} else {

				TreeNode curr = stack.pop();
				System.out.print(curr.val + "-");

				if (curr.right != null) {

					stack.push(curr.right);
					p = curr.right;
				}
			}
		}
	}

	/**
	 * 后序遍历 
	 * 关键： peek prev 1. 向左遍历（左的右） 2. 左往上 （检查右，有push，无，执行 ） 3. 右往上 执行
	 * 2种情况需要执行  a：最左        b：回溯父节点（分左往上方向和右往上方向）  
	 * 
	 * @param root
	 */
	static void postorderTraverval(TreeNode root) {

		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		TreeNode prev = null;

		while (!stack.isEmpty()) {

			TreeNode curr = stack.peek();
			
			//1. 向左遍历（左的右）
			if (prev == null || prev.left == curr || prev.right == curr) {

				if (curr.left != null)
					stack.push(curr.left);
				else if (curr.right != null)
					stack.push(curr.right);
				else {
					stack.pop();
					System.out.print(curr.val + "-");
				}
			}
			
			//2. 左往上 （检查右，有push，无，执行 ）
			else if (curr.left == prev) {

				if (curr.right != null)
					stack.push(curr.right);
				else {
					stack.pop();
					System.out.print(curr.val + "-");
				}
			}

			//3. 右往上 执行
			else if (curr.right == prev) {

				stack.pop();
				System.out.print(curr.val + "-");
			}

			prev = curr;
		}
	}

}
