package tp6_exercise1;

public class User {
	private String name;
	
	private String password;

	public User(String name, String password) throws NombreInvalidoException, ContrasenaInvalidaException {
		super();
		

		if (name == null || name.equals("")) {
			throw new NombreInvalidoException(name);
		}
		
		if (password == null || password.equals("")) {
			throw new ContrasenaInvalidaException(password);
		}
		
		
		this.name = name;
		this.password = password;
	}
	
	
}
