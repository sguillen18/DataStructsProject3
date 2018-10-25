

public class Passenger {
	private String id;
	private String destination;
	
	public Passenger(String id, String destination) {
		this.id = id;
		this.destination = destination;
	}
	
	public String getPassInfo() {
		return (id + ", " + destination);
	}
	
	public String getDestination() {
		return destination;
	}
	
	

}
