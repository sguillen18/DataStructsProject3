

public class Station {
	private String name;
	private LinkedQueue <Passenger> passengers;
	
	public Station(String n, LinkedQueue <Passenger> p) {
		name = n;
		passengers = p;
	}
	
	public String listOfPass() {
		LinkedQueue <Passenger> copy = new LinkedQueue <Passenger> ();
		copy= passengers.copy();
		String list = " ";
		
		while(!copy.isEmpty()) {
			Passenger p = passengers.dequeue();
			copy.enqueue(p);
			list += copy.dequeue().getPassInfo();
			list += "\n ";
		}
		
		passengers = copy;
		
		return list;
	}
	
	public String printStationInfo() {
		return name + " \nPassengers: \n" + listOfPass();
	}
	
	public String getName() {
		return name;
	}
	
	public void setPassList(LinkedQueue <Passenger> p) {
		passengers = p;
	}
	
	public LinkedQueue <Passenger> getPassList() {
		return passengers;
	}
}
