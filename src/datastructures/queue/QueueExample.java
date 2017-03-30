package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList();
		
		que.add(1);
		que.add(2);
		que.add(3);
		
		System.out.println("size = " + que.size());
		
		System.out.println("deque = " + que.remove());
		
		System.out.println("deque = " + que.remove());
		
		System.out.println("size = " + que.size());
		
		
	}
}
