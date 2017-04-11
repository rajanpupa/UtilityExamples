package graph.bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a graph,
 * traverse the given node by DFS method.
 */
public class Graph {
	int V;// no of vertices
	LinkedList<Integer> adj[];// Adjascency list

	Graph(int v) {
		V = v;
		adj = new LinkedList[v + 1];
		for (int i = 0; i <= v; i++) {
			adj[i] = new LinkedList();
		}
	}

	// function to add edge into the graph
	private void addEdge(int v, int w) {
		adj[v].add(w); // add w to v's list
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out
				.println("Following is Depth First Traversal (starting from vertex 2)");

		g.BFS(2);
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void BFS(int v) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V+1];// should be large enough to hold all the elements 

		// Call the recursive helper function to print DFS traversal
		BFSUtil(v, visited);
	}

	// A function used by DFS
	void BFSUtil(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		//visited[v] = true;
		//System.out.print(v + " ");
		
		Queue<Integer> queue = new LinkedList();
		queue.add(v);
		
		while(!queue.isEmpty()){
			int a = queue.remove();
			visited[a] = true;
			System.out.print(a + " ");
			Iterator<Integer> i = adj[a].listIterator();
			while(i.hasNext()){
				int n=i.next();
				if(!visited[n]){
					queue.add(n);
				}
			}
		}
	}
}
/*
 * Start from the root node, visit all the children first
 * then continue their children
 */
