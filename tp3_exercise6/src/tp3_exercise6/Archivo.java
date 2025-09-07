package tp3_exercise6;

public class Archivo extends Single {
	
	private String fecha_modificacion;
	
	private double tamanio;

	public Archivo(String fecha_creacion, String nombre, String fecha_modificacion, double tamanio) {
		super(fecha_creacion, nombre);
		this.fecha_modificacion = fecha_modificacion;
		this.tamanio = tamanio;
	}
	
	public double getTamano () {
		return this.tamanio;
	}

	public String getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(String fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
}
