package test;

import java.util.Stack;

public class evalRPN {

	public static void main(String[] args) {
		// String[] tokens = {"2", "1", "+", "3", "*"};
		String[] tokens = { "4", "13", "5", "/", "+" };

		// evalRPN.evalRPN(tokens);
		System.out.println(evalRPN.evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens) {

		Stack<String> stack = new Stack<String>();

		for (String s : tokens) {

			switch (s) {

			case "+": {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				String c = String.valueOf(a + b);
				stack.push(c);
				break;
			}

			case "-": {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				String c = String.valueOf(b - a);																																					
				stack.push(c);
				break;
			}
			case "*": {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				String c = String.valueOf(a * b);
				stack.push(c);
				break;
			}
			case "/": {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				String c = String.valueOf(b / a);
				stack.push(c);
				break;
			}
			default:
				stack.push(s);
			}

		}

		return Integer.valueOf(stack.pop());

	}

}
