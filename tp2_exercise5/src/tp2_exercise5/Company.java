package tp2_exercise5;

import java.util.HashMap;

public class Company {

    private HashMap<String, Bus> buses;
    
    private HashMap<String, Category> categories;
    
    private HashMap<String, Driver> drivers;

    private static Company instance = null;

    private Company() {
        this.buses = new HashMap<>();
        this.categories = new HashMap<>();
        this.drivers = new HashMap<>();
    }

    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }

    public Company addBus(String key, Bus bus) {
        this.buses.put(key, bus);
        return this;
    }
    
    public Company addCategory(String key, Category category) {
        this.categories.put(key, category);
        return this;
    }

    public Company addDriver(String key, Driver driver) {
        this.drivers.put(key, driver);
        return this;
    }

    public Bus getBus(String key) {
        return this.buses.get(key);
    }

    public Category getCategory(String key) {
        return this.categories.get(key);
    }

    public Driver getDriver(String key) {
        return this.drivers.get(key);
    }
    
    public void setCategoryToDriver (String driverId, String categoryId) {
    	Driver driver = this.getDriver(driverId);
    	Category category = this.getCategory(categoryId);
    	
    	if (driver == null || category == null) {
    		return;
    	}

    	driver.setCategory(category);
    }
    
    public void assignDriverToBus(String driverId, String busId) {
    	Driver driver = this.drivers.get(driverId);
    	Bus bus = this.buses.get(busId);
    	
    	if (bus == null || driver == null) {
    		return;
    	}
    	
    	bus.assingDriver(driver);
    	driver.assignBus(bus);
    }
    
    public void unassignDriverToBus(String driverId, String busId)  {
    	Driver driver = this.drivers.get(driverId);
    	Bus bus = this.buses.get(busId);
    	
    	if (bus == null || driver == null) {
    		return;
    	}
    	
    	bus.unassingDriver();
    	driver.unassigngBus();
    }
        
    @Override
    public String toString() {
        String result = "=== TRANSPORT SYSTEM ===\n";
        
        result += "\nCATEGORIES:\n";
     	for(Category category:this.categories.values()) {
    		result += category.toString() + "\n";
    	}
        
        result += "\nDRIVERS:\n";
        for(Driver driver : this.drivers.values()) {
            result += driver.toString() + "\n";
        }
        
        result += "\nBUSES:\n";
        for(Bus bus : this.buses.values()) {
            result += bus.toString() + "\n";
        }
        
        return result;
    }
}

