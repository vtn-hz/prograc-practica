package tp2_exercise5;

public class Driver {
	private Category category;
	
	private Address address;
	
	private Bus bus;
	
	private String name;

	public Driver(Category category, Address address, String name) {
		super();
		this.category = category;
		this.address = address;
		this.name = name;
		this.bus = null;
	}
	
	public Driver(Address address, String name) {
		super();
		this.address = address;
		this.name = name;
		this.bus = null;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public double getSalary () {
		return this.category.getSalary();
	}
	
	public boolean isDriving () {
		return this.bus != null;
	}
	
	public void assignBus (Bus bus) {
		this.bus = bus;
	}	
	
	public void unassigngBus() {
		this.bus = null;
	}
	
	public Bus getAssignedBus ()  {
		return this.bus;
	}

	@Override
	public String toString() {
		return "Driver [" +
					"category=" + category + 
					", salary=" + this.getSalary() + 
					", address=" + address + 
					", name=" + name +
					", isDriving=" + this.isDriving() 
				+ "]";
	}
	
	
}
