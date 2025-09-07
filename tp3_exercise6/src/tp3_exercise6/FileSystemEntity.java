package tp3_exercise6;

public abstract class FileSystemEntity {
	private String fecha_creacion;
	
	private String nombre;
		
	public FileSystemEntity(String fecha_creacion, String nombre) {
		super();
		this.fecha_creacion = fecha_creacion;
		this.nombre = nombre;
	}


	public abstract double getTamano();
	
	public abstract void print();

	public String getFecha_creacion() {
		return fecha_creacion;
	}


	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
