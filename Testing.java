import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		//user gives number of stations
		//user gives time interval of time passing between stations
		//user gives time of entire sim
		
		int simTimeTot = 0;
		int trainStationTime = 0;
		int numOfTrains = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(simTimeTot == 0 || trainStationTime == 0 ||
				trainStationTime < 0 || trainStationTime > 30 || (simTimeTot*60) < trainStationTime || trainStationTime > (simTimeTot*60 - trainStationTime) || 0 > (simTimeTot*60 - trainStationTime) ) {
			
			System.out.println("Input how long you want the simulation to last, in hours: ");
			simTimeTot = sc.nextInt();
			
			System.out.println("Input how long you want the trains to take from station to station, in minutes, from 1 - 30: ");
			trainStationTime = sc.nextInt();
			 
			if(simTimeTot == 0 || trainStationTime == 0) {
				System.out.println("There was an invalid answer of 0. Please try again with valid answers");
			}
			if(trainStationTime < 0 || trainStationTime > 30) {
				System.out.println("There was an answer out of bounds. Please try again with valid answers");
			}
			if((simTimeTot*60) < trainStationTime) {
				System.out.println("The simulation time should be larger than the train time. Please try again with valid answers");
			}
			
			if(trainStationTime > (simTimeTot*60 - trainStationTime) || 0 > (simTimeTot*60 - trainStationTime)) {
				System.out.println("The time the trains take from station to station should be smaller. Please try again with valid answers");
			}
			
		}
		
		int simTimeTotMinutes = simTimeTot*60;
		int lastTrainSendOutTime = trainStationTime * 32;
		numOfTrains = (simTimeTotMinutes - lastTrainSendOutTime) / trainStationTime;
		System.out.println(numOfTrains);
		
		
		Train[] t = new Train[numOfTrains];
		Route r = new Route();
		r.createStations();
		
		for(int i = 0; i < numOfTrains; i++) {
			t[i] = r.createNewTrain();
		}
		
		int time = 0;
		r.newPassengers();
		int it = 0;
		while(it != (32 + numOfTrains)){
			System.out.println("Time: " + time + " minutes");
			for(int j = 0; j < numOfTrains + 1; j++) {
				int num = (int) (Math.random()* 10);
				if(num < 5) {
					r.newPassengers();
				}
				for(int k = 0; k < j; k++) {
					System.out.println("Train " + (k + 1) + " is at " + t[k].getCurrentStation().getName() + " Station");
					System.out.println(" Leaving Passengers: ");
					Station curr = t[k].getCurrentStation();
					curr.trainArrived(t[k]);
					t[k].setCurrentStation(r.nextStation(t[k]));
				}
				time += trainStationTime; 
				System.out.println("");
			}
		}
		
		
		sc.close();
	}

}
