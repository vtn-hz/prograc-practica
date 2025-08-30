package tp2_exercise5;

public class Driver {
	private Category category;
	
	private Address address;
	
	private String name;
	
	private boolean isDriving;

	public Driver(Category category, Address address, String name) {
		super();
		this.category = category;
		this.address = address;
		this.name = name;
		this.isDriving = false;
	}
	
	public double getSalary () {
		return this.category.getSalary();
	}
	
	public boolean isDriving () {
		return this.isDriving;
	}
	
	public void isDriving (boolean status) {
		this.isDriving = status;
	}	

	@Override
	public String toString() {
		return "Driver [" +
					"category=" + category + 
					", address=" + address + 
					", name=" + name + 
					", isDriving=" + isDriving
				+ "]";
	}
	
	
}
