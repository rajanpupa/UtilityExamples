package barclays;

import java.util.ArrayList;
import java.util.List;

/*
 * 
:: Conveyer system
	Node1 Node2 travel_time
	
:: Departure list 
	flightid  flightgate  destination  flighttime
	
:: Bag list
	bag_number  entry_point  flight_id
	
:: Output: The optimized route for each bag
```
<Bag_Number> <point_1> <point_2> [<point_3>, …] : <total_travel_time>
```

 */

public class AConvayerSystemApplication {
	
	static List<Bag> bags = new ArrayList<>();
	static List<Departure> departures = new ArrayList<>();
	static List<ConveyerEdge> conveyer = new ArrayList<>();

	public static void main(String[] args) {
		initializeBags();
		initializeDepartures();
		initializeConveyer();
	}

	private static void initializeConveyer() {
		// flightid  flightgate  destination  flighttime
		conveyer.add(new ConveyerEdge("Concourse_A_Ticketing A5 5"));
		conveyer.add(new ConveyerEdge("A5 BaggageClaim 5"));
		conveyer.add(new ConveyerEdge("A5 A10 4"));
		conveyer.add(new ConveyerEdge("A5 A1 6"));
		
		conveyer.add(new ConveyerEdge("A1 A2 1"));
		
		conveyer.add(new ConveyerEdge("A2 A3 1"));
		conveyer.add(new ConveyerEdge("A3 A4 1"));
		conveyer.add(new ConveyerEdge("A10 A9 1"));
		conveyer.add(new ConveyerEdge("A9 A8 1"));
		conveyer.add(new ConveyerEdge("A8 A7 1"));
		conveyer.add(new ConveyerEdge("A7 A6 1"));
	}

	private static void initializeDepartures() {
		//flightid  flightgate  destination  flighttime
		departures.add(new Departure("UA10 A1 MIA 08:00"));
		departures.add(new Departure("UA11 A1 LAX 09:00"));
		departures.add(new Departure("UA12 A1 JFK 09:45"));
		departures.add(new Departure("UA13 A2 JFK 08:30"));
		
		departures.add(new Departure("UA14 A2 JFK 09:45"));
		departures.add(new Departure("UA15 A2 JFK 10:00"));
		departures.add(new Departure("UA16 A3 JFK 09:00"));
		departures.add(new Departure("UA17 A4 MHT 09:15"));
		
		departures.add(new Departure("UA18 A5 LAX 10:15"));
	}

	private static void initializeBags() {
		//bag_number  entry_point  flight_id
		bags.add(new Bag("0001", "Concourse_A_Ticketing", "UA12"));
		bags.add(new Bag("0002", "A5", "UA17"));
		bags.add(new Bag("0003", "A2", "UA10"));
		bags.add(new Bag("0004", "A8", "UA18"));
		bags.add(new Bag("0005", "A7", "ARRIVAL"));
	}
}
