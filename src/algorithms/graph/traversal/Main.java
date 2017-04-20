package graph.traversal;


public class Main {

	public static void main(String[] args) {
		Graph g = new Graph(6);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(3,4);
		g.addEdge(4,5);
		
		int startPoint = 0;
		
		System.out.printf("Starting from %d, depth first search path is: \n", startPoint);
		g.depthFirstSearch(startPoint);
		System.out.println();
		
		System.out.printf("Starting from %d, breadth first search path is: \n", startPoint);
		g.breadthFirstSearch(startPoint);
		System.out.println();
	}
}
