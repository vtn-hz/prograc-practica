package tp6_exercise1;

@SuppressWarnings("serial")
public class ContrasenaInvalidaException extends Exception {

	public ContrasenaInvalidaException(String contrasena) {
		super("La contrasena " + contrasena + " es invalida.");
	}
	
	
}
