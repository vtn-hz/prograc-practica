package tp6_exercise3.exceptions;

public class CargaInvalidaException extends Exception {
	DatoCargaInvalida datoCargaInvalida;

	public CargaInvalidaException(String message, String combustible, double cantidadRequerida, double cantidadDisponible) {
		super(message);
		this.datoCargaInvalida = new DatoCargaInvalida(combustible, cantidadRequerida, cantidadDisponible);
	}

	public DatoCargaInvalida getDatoCargaInvalida() {
		return datoCargaInvalida;
	}
}
