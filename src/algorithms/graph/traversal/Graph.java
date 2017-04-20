package graph.traversal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	
	int size ;
	List<Integer> adj[];
	
	public Graph(int size){
		this.size = size;
		adj = new LinkedList[size];
		
		for(int i=0; i<size; i++){
			adj[i] = new LinkedList();
		}
	}
	
	public void addEdge(int i, int j) {
		adj[i].add(j);
	}
	
	public void depthFirstSearch(int startingPoint){
		boolean [] visited = new boolean[size+1];
		
		dfsUtil(startingPoint, visited);
	}
	
	private void dfsUtil(int elem, boolean[] visited) {
		visited[elem]=true;
		System.out.printf(" " + elem);
		
		Iterator<Integer> it = adj[elem].listIterator();
		
		while(it.hasNext()){
			int i = it.next();
			
			if(!visited[i]){
				visited[i]=true;
				dfsUtil(i, visited);
			}
			
		}
	}

	public void breadthFirstSearch(int startingPoint){
		boolean [] visited = new boolean[size+1];
		bfsUtil(startingPoint, visited);
	}

	private void bfsUtil(int elem, boolean[] visited) {
		visited[elem] = true;
		
		Queue<Integer> q = new LinkedList();
		q.add(elem);
		
		while(!q.isEmpty()){
			int i = q.remove();
			System.out.print(" " + i);
			
			for(Integer j: adj[i]){
				if(!visited[j]){
					q.add(j);
					visited[j] = true;
				}
			}
		}
	}

}
