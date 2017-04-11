package barclays;

public class ConveyerEdge {

	// Node1 Node2 travel_time
	// Concourse_A_Ticketing A5 5
	
	String node1;
	String node2;
	String travelTime;
	
	public ConveyerEdge(String line){
		String [] token = line.split(" ");
		
		this.node1 = token[0];
		this.node2 = token[1];
		this.travelTime = token[2];
	}
	
	public boolean isEqualTo(String node1, String node2){
		return this.node1.equals(node1) && this.node2.equals(node2);
	}
	

	public String getNode1() {
		return node1;
	}

	public void setNode1(String node1) {
		this.node1 = node1;
	}

	public String getNode2() {
		return node2;
	}

	public void setNode2(String node2) {
		this.node2 = node2;
	}

	public String getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	
	
}
