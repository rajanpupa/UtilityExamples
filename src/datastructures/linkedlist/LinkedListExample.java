package linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {
		List<Integer> l = new LinkedList();
		
		l.add(1);
		l.add(2);
		
		l.add(3);
		
		l.forEach(System.out::println);;
		System.out.println("-------------------------");
		
		l.add(1,4);
		l.forEach(System.out::println);;
		System.out.println("-------------------------");
		
		l.remove(2);
		l.forEach(System.out::println);;
		System.out.println("-------------------------");
		
		System.out.println("the index of 4 is " + l.indexOf(4));
		
	}
}
