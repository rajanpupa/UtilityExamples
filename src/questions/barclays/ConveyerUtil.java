package barclays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConveyerUtil {

	public static String getDestNode(String flightId, List<Departure> departures){
		String destNode = null;
		
		for(Departure d : departures){
			if(d.getFlightId().equals(flightId)){
				destNode = d.getFlightGate();
			}
		}
		
		return destNode;
	}
	
	public static List<String> getFastestNodes(String srcNode, String destNode, List<ConveyerEdge> edges){
		List<String> route = new ArrayList<>();
		
		// Node1 Node2 travel_time
		// search here
		List<String> allNodes = findDistinctNodes(edges);
		
		int[][] matrix = new int[allNodes.size()][allNodes.size()];
		
		for(int i=0; i<allNodes.size(); i++){
			for(int j=0; j<allNodes.size(); j++){
				if(i==j){
					matrix[i][j] = 0;
					break;
				}
				
				for(int k=0; k<edges.size(); k++){
					if(edges.get(k).isEqualTo(allNodes.get(i), allNodes.get(j))){
						matrix[i][j] = Integer.parseInt(edges.get(k).getTravelTime());
						break;
					}else{
						matrix[i][j] = -1;
					}
				}
				
			}
		}
		
		
		
		
		return route;
	}
	
	public static List<String> findDistinctNodes(List<ConveyerEdge> edges){
		
		HashSet<String> s = new HashSet<>();
		
		for(ConveyerEdge e : edges){
			s.add(e.getNode1());
			s.add(e.getNode2());
		}
		
		return new ArrayList<String>(s);
	}
}
