package graph.dfs;

import java.util.Iterator;
import java.util.LinkedList;

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

		g.DFS(1);
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS(int v) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V+1];// should be large enough to hold all the elements 

		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, visited);
	}

	// A function used by DFS
	void DFSUtil(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if ( !visited[n] )
				DFSUtil(n, visited);
		}
	}
}
