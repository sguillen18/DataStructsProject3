
public class Train {
	private LinkedBag <Passenger> bagOfPassengers;
	private boolean forward = true;
	private int capacityMax = 100;
	private int numOfPass;
	private Station currStation;
	
	public Train() {
		bagOfPassengers = new LinkedBag <Passenger> ();
		numOfPass = 0;
	}
	
	public void setCurrentStation(Station s) {
		currStation = s;
	}
	
	public Station getCurrentStation() {
		return currStation;
	}
	
	public int getNumberOfPassengers() {
		return numOfPass;
	}
	
	public boolean getDirection() {
		return forward;
	}
	
	public LinkedBag <Passenger> getBagOfPassengers(){
		return bagOfPassengers;
	}
	
	public void setDirection(String dir) {
		if(dir.equalsIgnoreCase("foward")){
			forward = true;
		}
		if(dir.equalsIgnoreCase("backwards")){
			forward = false;
		}
	}
	
	public boolean addToBagOfPass(Passenger anEntry) {
		if(numOfPass <= capacityMax - 1) {
			bagOfPassengers.add(anEntry);
			numOfPass++;
			return true;
		}
		return false;
	}
	
	public void removeFromBagOfPass(Passenger anEntry) {
		bagOfPassengers.remove(anEntry);
		numOfPass--;
	}
	
	public Passenger[] passengerBagToArray() {
		Object[] op = bagOfPassengers.toArray();
		Passenger [] p = new Passenger [op.length];
		for (int i = 0; i < op.length; i++)
			p[i] = (Passenger)op[i];
		return p;
	}
	
	
	
}
