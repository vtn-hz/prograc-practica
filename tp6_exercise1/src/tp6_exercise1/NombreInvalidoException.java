package tp6_exercise1;

@SuppressWarnings("serial")
public class NombreInvalidoException extends Exception {

	public NombreInvalidoException(String nombre) {
		super("El nombre " + nombre + " es invalido.");
	}
	
	
}
