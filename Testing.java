import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		//user gives number of stations
		//user gives time interval of time passing between stations
		//user gives time of entire sim
		
		double simTimeTot = 0;
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input how long you want the simulation to last, in hours (can be decimal): ");
		simTimeTot = sc.nextDouble();
		
		
		
		sc.close();
	}

}
