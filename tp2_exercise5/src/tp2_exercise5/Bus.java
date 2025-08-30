package tp2_exercise5;

public class Bus {
	private String model;
	
	private Driver driver;
	
	private static int serialNumber = 0;
	
	public Bus (String model) {
		this.model = model;
		Bus.serialNumber++;
	}
	
	// https://stackoverflow.com/questions/2506488/when-is-the-finalize-method-called-in-java
	protected void finalize() throws Throwable {
		super.finalize(); // deprecated (?)
		Bus.serialNumber--; // this is incorrect
	}
	
	public static int getSerialNumber () {
		return Bus.serialNumber;
	}
	
	public void assingDriver(Driver driver) {
		this.driver = driver;
		this.driver.isDriving(true);
	}
	
	public void unassingDriver(Driver driver) {
		this.driver = null;
		this.driver.isDriving(false);
	}

	@Override
	public String toString() {
		return "Bus [model=" + model + ", driver=" + driver + "]";
	}
}
