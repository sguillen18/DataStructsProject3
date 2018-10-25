

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
	
	public void trainArrived(Train t) {
		Passenger[] onTrain = t.passengerBagToArray();
		
		for(int j = t.getNumberOfPassengers() ; j > 0; j++) {
			if(name.equals(onTrain[j].getDestination())) {
				t.removeFromBagOfPass(onTrain[j]);
			}
		}
		
		if((t.getNumberOfPassengers() + passengers.getSize()) > 100) {
			int allowedOn = 100 - t.getNumberOfPassengers();
			for(int i = 0; i < allowedOn; i++) {
				Passenger anEntry = passengers.dequeue();
				t.addToBagOfPass(anEntry);
			}
		}
		
		else if (passengers.getSize() > 100) {
			for(int i = 0; i < 100; i++) {
				Passenger anEntry = passengers.dequeue();
				t.addToBagOfPass(anEntry);
			}
		}
		
		else {
			for(int i = 0; i < passengers.getSize(); i++) {
				Passenger anEntry = passengers.dequeue();
				t.addToBagOfPass(anEntry);
			}
		}
	}
}
