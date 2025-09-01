package tp2_exercise5;

public class Main {
    public static void main(String[] args) {
        Company company = Company.getInstance();

        company.addCategory("common", new Category("common", 1000))
               .addCategory("premium", new Category("premium", 2500));

        company.addDriver("driver1", new Driver(
            company.getCategory("common"),
            new Address("Luro", 2013),
            "Carlos"
        ));

        company.addDriver("driver2", new Driver(
            company.getCategory("premium"),
            new Address("Libertad", 1223),
            "Javier"
        ));

        company.addBus("bus1", new Bus("Mercedes 2001"))
               .addBus("bus2", new Bus("Mercedes 2011"))
               .addBus("bus3", new Bus("Mercedes 2023"));

        
        company.assignDriverToBus("driver1", "bus1");
        // finalize is not called immediately
        // GC doesnt destroy immediately  

        System.out.println( company );
    }
}
