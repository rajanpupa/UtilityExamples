package stack;

import java.util.Stack;

/*
 * This solution is the books approach
 * My approach is on StackWithMin2
 */
public class StackWithMin extends Stack<NodeWithMin>{
	
	public static void main(String[] args) {
		StackWithMin swm = new StackWithMin();
		swm.push(1);
		swm.push(3);
		swm.push(6);
		swm.push(1);
		swm.push(0);
		swm.push(5);
		
		System.out.printf("Min element in stack is %d", swm.min());
	}
	
	public void push(int value){
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
		if(this.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return peek().min;
		}
	}
	
}

class NodeWithMin{
	public int value;
	public int min;
	public NodeWithMin(int value, int min){
		this.value = value;
		this.min = min;
	}
}