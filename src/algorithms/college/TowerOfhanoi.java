package college;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TowerOfhanoi {
	
	public static void main(String[] args) {
		Stack a = new Stack('a');
		a.pushAll(Arrays.asList(3,2,1));
		
		Stack b = new Stack('b');//dest
		
		Stack c = new Stack('c'); // temp
		
		System.out.println("stack a = " + a);
		move(a , b, c);
		
		System.out.println("stack b = " + b);
	}

	public static void move(Stack source, Stack destination, Stack buffer) {
		move(source.size(), source, destination, buffer);
	}
	
	/*
	 * move n-1 items from source to buffer
	 * then move last item from source to destination
	 * then move n-1 items from buffer to destination
	 */
	private static void move(Integer n, Stack source, Stack destination, Stack buffer){
		if(n==0) return;
		else if(n==1){
			destination.push(source.pop());
		}else{
			
			move(n-1, source, buffer, destination);
			destination.push(source.pop());
			move(n-1, buffer, destination, source);
		}
	}
	
}

class Stack{
	int top = 0;
	char name = 'z' ;
	
	public Stack(){}
	public Stack(char name){
		this.name = name;
	}
	
	List<Integer> lst = new ArrayList<>();
	
	public void pushAll(List<Integer> lst){
		
		for(Integer i: lst){
			push(i);
		}
	}
	
	public Integer size(){
		return lst.size();
	}
	
	public void push(Integer i){
		System.out.printf(" -> inserting %d to %s \n" , i, name);
		lst.add(top++, i);
	}
	
	boolean isEmpty(){
		return top == 0;
	}
	
	public Integer pop(){
		Integer i = lst.remove(--top);
		System.out.printf(" removing %d from %s", i, name);
		return i;
	}
	
	@Override
	public String toString() {
		return lst.toString();
	}
}