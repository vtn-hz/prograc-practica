package tp6_exercise3.exceptions;

public class FaltaCombustibleException extends CargaInvalidaException {

	public FaltaCombustibleException(String message, String combustible, double cantidadRequerida,
			double cantidadDisponible) {
		super(message, combustible, cantidadRequerida, cantidadDisponible);
		// TODO Auto-generated constructor stub
	}

}
