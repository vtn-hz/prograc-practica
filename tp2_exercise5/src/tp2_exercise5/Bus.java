package tp2_exercise5;

public class Bus {
	private int serialNumber;
	
	private String model;
	
	private Driver driver;
	
	private static int nextSerialNumber = 1;
	
	public Bus (String model) {
		this.model = model;
		this.serialNumber = Bus.nextSerialNumber++;
	}
	
	// https://stackoverflow.com/questions/2506488/when-is-the-finalize-method-called-in-java
	protected void finalize() throws Throwable {
		super.finalize(); // deprecated (?)
	}
	
	public int getSerialNumber () {
		return this.serialNumber;
	}
	
	public void assingDriver(Driver driver) {
		this.driver = driver;
	}
	
	public void unassingDriver() {
		this.driver = null;
	}
	
	public Driver getAssignedDriver ()  {
		return this.driver;
	}

	@Override
	public String toString() {
		return "Bus [serialNumber="+ this.serialNumber + ", model=" + model + ", driver=" + driver + "]";
	}
}
