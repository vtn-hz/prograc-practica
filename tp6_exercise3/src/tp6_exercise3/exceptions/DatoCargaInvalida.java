package tp6_exercise3.exceptions;

public class DatoCargaInvalida {
	private String combustible;
	
	private double cantidadRequerida;
	
	private double cantidadDisponible;
	
	public DatoCargaInvalida(String combustible, double cantidadRequerida, double cantidadDisponible) {
		super();
		this.combustible = combustible;
		this.cantidadRequerida = cantidadRequerida;
		this.cantidadDisponible = cantidadDisponible;
	}

	public double getCantidadDisponible() {
		return cantidadDisponible;
	}

	public double getCantidadRequerida() {
		return cantidadRequerida;
	}

	public String getCombustible() {
		return combustible;
	}
	
}
