package tp2_exercise4;

public class Employee {
	private String name;
	
	private String telephone;
	
	private String email;

	public Employee(String name, String telephone, String email) {
		super();
		this.name = name;
		this.telephone = telephone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", telephone=" + telephone + ", email=" + email + "]";
	}
}
