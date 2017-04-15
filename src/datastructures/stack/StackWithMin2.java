package stack;

import java.util.Stack;

/*
 * This solution is the books approach
 * My approach is on StackWithMin2
 * 
 * Approach in StackWithMin2 will have a problem when popping.
 * The info about the min will be lost if the min element itself is poped
 */
public class StackWithMin2 extends Stack<Integer>{
	//x = ~x;
	Integer min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		StackWithMin2 swm = new StackWithMin2();
		swm.push(1);
		swm.push(3);
		swm.push(6);
		swm.push(1);
		swm.push(0);
		swm.push(5);
		
		System.out.printf("Min element in stack is %d", swm.min());
	}
	
	public Integer push(Integer i){
		min = Math.min(min, i);
		super.push(i);
		return i;
	}
	
	public Integer pop() {
		return super.pop();
	}

	public Integer min(){
		return this.min;
	}
	
	
	
}