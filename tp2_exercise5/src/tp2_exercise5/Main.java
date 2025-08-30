package tp2_exercise5;

import java.lang.Thread;

public class Main {

	public static void main(String[] args) {
		Category[] categories = { 
				new Category("common", 1000), 
				new Category("premium", 2500), 
		};
		
		Driver driver1 = new Driver(
			categories[0],
			new Address("Luro", 2013),
			"Carlos"
		); 
		
		Driver driver2 = new Driver(
			categories[1],
			new Address("Libertad", 1223),
			"Javier"
		); 
		
		Bus[] buses = {
			new Bus("Mercedes 2001"),
			new Bus("Mercedes 2011"),
			new Bus("Mercedes 2023")
		};
		
		System.out.println(Bus.getSerialNumber());
		buses[2] = null; 	// finalize is not called immediately
							// GC doesnt destroy immediately  
		System.out.println(Bus.getSerialNumber());

		System.out.println( buses[0] );
		buses[0].assingDriver(driver2);
		System.out.println( buses[0] );
		System.out.println( driver1 );
		System.out.println( driver1.getSalary() );
		
		
		
		
	}

}
