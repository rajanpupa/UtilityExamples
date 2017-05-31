package amazon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * There are various jobs in a computer and jobs can run in parallel.
 * Some jobs might depend on another job.
 * Job have their own execution time.
 * Given a job, write an algorithm to find the execution time
 */
/*
 * Basically this is a graph problem, where the execution time is the maxumum weighing path 
 * found with DFS algorithm
 */
public class DependentJob {

	public static void main(String[] args) {
		Graph g = new Graph(4);
		
		g.addJob(0, 2);
		g.addJob(1, 2);
		g.addJob(2, 4);
		g.addJob(3, 6);
		
		g.addDependencies(3, new int[]{1,2});
		g.addDependency(1, 0);
		g.addDependency(2, 0);
		
		System.out.println(g.findExecutionTime(3));
	}
}

class Graph{
	int v;
	List<Integer> adj[];
	int[] exTime;
	
	public Graph(int v){
		this.v = v;
		adj = new LinkedList[v];
		exTime = new int[v];
		
		// initialize array
		for(int i=0; i<v; i++){
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addJob(int a, int Time){
		exTime[a] = Time;
	}
	
	public void addDependency(int job, int dependency){
		adj[job].add(dependency);
	}
	
	public void addDependencies(int job, int [] dependencies){
		for(int i=0; i<dependencies.length; i++){
			adj[job].add(dependencies[i]);
		}
	}
	
	public Integer findExecutionTime(Integer vertex){
		Map<Integer, Integer> memoizedExTime = new HashMap<>();
		return findMaxTime(vertex, memoizedExTime);
	}

	private Integer findMaxTime(Integer vertex, Map<Integer, Integer> mem) {
		if(mem.get(vertex) != null) return mem.get(vertex);
		if(adj[vertex].size() == 0) {
			mem.put(vertex, exTime[vertex]);
			return exTime[vertex];
		}
		else{
			int max = 0, temp = 0;
			
			Iterator<Integer> it = adj[vertex].iterator();
			
			while(it.hasNext()){
				temp = findExecutionTime(it.next());
				if(temp > max) max = temp;
			}
			
			mem.put(vertex, max + exTime[vertex]);
			return max + exTime[vertex];
		}
	}
}
