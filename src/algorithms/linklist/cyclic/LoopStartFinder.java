package linklist.cyclic;

/*
 * Given a circular linked list. 
 * Implement an algorithm which returns node at the beginning of the loop.
 * a->b->c->d->e->c
 * return c
 */
public class LoopStartFinder {

	public static void main(String[] args) {
		Node head = new Node('a');
		Node b = head.next = new Node('b');
		Node c = b.next = new Node('c');
		Node d = c.next = new Node('d');
		Node e = d.next = new Node('e');
		Node f = e.next = new Node('f');
		Node g = f.next = new Node('g');
		g.next = head;
		
		printCycleList(head, 'a');
		
		Node loopStart = getLoopStart(head);
		
		System.out.printf("The loop starter node is %s \n", loopStart.value);
	}
	
	

	private static Node getLoopStart(Node head) {
		Node l1,l2;
		l1=head;
		l2 = head;
		
		// move l2 twice as l1 until they meet
		do{
			l1=l1.next;
			l2=l2.next;
			if(l2 != null){
				l2 = l2.next;
			}
		}while(l1 != null && l2 != null && l1.value != l2.value);
		
		if(l2==null){
			// not cyclic
			return null;
		}
		// else l1 and l2 have met.
		l1 = head;
		while(l1.value != l2.value){
			l1=l1.next;
			l2=l2.next;
		}
		
		return l1;
	}



	private static void printCycleList(Node head, char c) {
		int ccount = 0;
		Node temp = head;
		while(ccount < 2){
			System.out.printf("%s -> " ,temp.value );
			if(temp.value == c){
				ccount ++;
			}
			temp = temp.next;
		}
		
		System.out.println();
	}
}

class Node{
	public char value;
	public Node next;
	
	public Node(){}
	public Node(char c){
		this.value = c;
	}
}