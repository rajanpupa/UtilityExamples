package stack;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println("top item = " + stack.peek());
		
		stack.push(4);
		
		System.out.println("poped item = " + stack.pop());
		
		System.out.println("next pop = " + stack.pop());
		
		stack.push(5);
		System.out.println("next top = " + stack.peek());
		
		System.out.println("size = " + stack.size());
	}
}
