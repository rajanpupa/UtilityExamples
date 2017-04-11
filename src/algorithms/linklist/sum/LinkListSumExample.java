package linklist.sum;

/*
 * 1   1->2->3->7
 * 2   		 2->9
 * 
 * resule : 1->2->6->6
 */
public class LinkListSumExample {
	
	public static class Node{
		int value;
		Node next;
		
		public Node(int value){
			this.value = value;
		}
	}

	
	public static void main(String[] args) {
		// 1->2->3->7
		Node n1 = new Node(1);
		Node n12 = new Node(2);
		n1.next = n12;
		Node n13 = new Node(3);
		n12.next = n13;
		Node n14 = new Node(7);
		n13.next = n14;
		
		// 2->9
		Node n2 = new Node(2);
		Node n22 = new Node(9);
		n2.next = n22;
		
		Node sum = listSum(n1, n2);
		
		Node temp = sum;
		
		while(temp!=null){
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
	}
	
	private static Node listSum(Node n1, Node n2) {
		
		Node l1 = n1, l2=n2;
		
		while(l1 != null && l2 != null){
			l1=l1.next;
			l2=l2.next;
		}
		
		Node longer = l1.next==null? n2 : n1;
		Node shorter = l1.next==null? n1 : n2;
		
		int diff = 0;
		
		while(l1!=null){
			diff++;
			l1=l1.next;
		}
		while(l2!=null){
			diff++;
			l2=l2.next;
		}
		
		
		Node res = new Node(0);
		Node temp = res;
		
		while(diff > 0){
			diff--;
			
			temp.next = new Node(longer.value);
			
			longer = longer.next;
			temp=temp.next;
		}
		
		//temp.next = new Node(0);
		int carry = recursivelyAdd(longer, shorter, temp);
		
		int sum =longer.value + shorter.value + carry;
		if(sum>9){
			System.out.println("sth wrong with output");
		}
		//temp.value = sum%10;
		
		
		return res;
	}

	private static int recursivelyAdd(Node longer, Node shorter, Node current) {
		if(longer.next == null && shorter.next==null){
			int sum = longer.value + shorter.value;
			
			current.next= new Node(sum%10);
			
			return sum/10;
		}else{
			current.next = new Node(0);
			int carry = recursivelyAdd(longer.next, shorter.next, current.next);
			
			int sum = longer.value + shorter.value + carry;
			
			current.next.value=sum%10;
			
			return sum/10;
			
		}
	}
}
