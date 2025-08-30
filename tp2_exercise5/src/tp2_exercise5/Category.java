package tp2_exercise5;

public class Category {
	private String name; 
	
	private double salary;

	public Category(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		return name + ": " + salary;
	}	
}
