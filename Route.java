
public class Route {
	private Station[] stations = new Station[17]; 
	private int trainAt;
	
	public Route() {
	}
	
	public String randID() {
		String identification = "";
		for(int i = 0; i < 5; i++) {
			int num = (int) (Math.random()* 10);
			identification += num;
		}
		return identification;
	}
	
	public int randStation() {
		int num = (int) (Math.random()* 17);
		return num;
	}
	
	public void createStations(){
		//creates new stations
		Station og = new Station("Oak Grove", null);
		Station w = new Station("Wellington", null);
		Station a = new Station("Assembly", null);
		Station ss = new Station("Sullivan Square", null);
		Station cc = new Station("Community College", null);
		Station h = new Station("Haymarket", null);
		Station dc = new Station("Downtown Crossing", null);
		Station c = new Station("Chinatown", null);
		Station tmc = new Station("Tufts Medical Center", null);
		Station bb = new Station("Back Bay", null);
		Station ma = new Station("Massachusetts Avenue", null);
		Station r = new Station("Ruggles", null);
		Station rc = new Station("Roxbury Crossing", null);
		Station js = new Station("Jackson Square", null);
		Station sb = new Station("Stony Brook", null);
		Station gs = new Station("Green Street", null);
		Station fh = new Station("Forest Hill", null);
		
		//adds to array
		stations[0] = og;
		stations[1] = w;
		stations[2] = a;
		stations[3] = ss;
		stations[4] = cc;
		stations[5] = h;
		stations[6] = dc;
		stations[7] = c;
		stations[8] = tmc;
		stations[9] = bb;
		stations[10] = ma;
		stations[11] = r;
		stations[12] = rc;
		stations[13] = js;
		stations[14] = sb;
		stations[15] = gs;
		stations[16] = fh;	
	}
	
	public int newPassengers() {
		
		System.out.println("boop");
		
		//sets passList to 0 entries
		for(int j = 0; j < 17; j++) {
			LinkedQueue <Passenger> pa = new LinkedQueue <Passenger> ();
			stations[j].setPassList(pa);
		}
		
		int r = (int) (Math.random()* 50);
		
		for(int i = 0; i < r; i++) {
			String id = randID();
			int num = randStation();
			Station s = stations[num];
			String stat = s.getName();
			Passenger p = new Passenger(id, stat);

			LinkedQueue <Passenger> copyList = s.getPassList().copy();
			copyList.enqueue(p);
			s.setPassList(copyList);
		}
		
		return r;
	}
	
	
	public Station nextStation(Train t) {
		int stat = (trainAt(t.getCurrentStation()));
		if(t.getDirection()) {
			if(stat == 16) {
				t.setDirection("backwards");
				Station next = stations[stat];
				return next;
			}
			stat++;
			Station next = stations[stat];
			return next;
		}
		else {
			if(stat == 0) {
				t.setDirection("forwards");
				Station next = stations[stat];
				return next;
			}
			stat--;
			Station next = stations[stat];
			return next;
		}
	}
	
	private int trainAt(Station s) {
		for(int i = 0; i < 17; i++) {
			if(s.equals(stations[i])) {
				trainAt = i;
			}
		}
		return trainAt;
	}
	
	public Train createNewTrain() {
		Train t = new Train();
		Station[] s = getStationArray();
		
		//makes s[0] the terminal
		t.setCurrentStation(s[0]);
		
		return t;
	}
	
	
	public Station[] getStationArray() {
		return stations;
	}
}
