package barclays;

public class Departure {
	String flightId;
	String flightGate;
	String flightTime;
	String destination;
	
	public Departure(String flightId, String flightGate, String destination, String flightTime){
		this.flightId = flightId;
		this.flightGate = flightGate;
		this.destination = destination;
		this.flightTime = flightTime;
	}
	
	public Departure(String line){
		// UA10 A1 MIA 08:00
		String [] tokens = line.split(" ");
		
		this.flightId = tokens[0];
		this.flightGate = tokens[1];
		this.destination = tokens[2];
		this.flightTime = tokens[3];
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightGate() {
		return flightGate;
	}

	public void setFlightGate(String flightGate) {
		this.flightGate = flightGate;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
}
