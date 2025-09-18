package tp4_exercise8.model;

abstract public class Personaje {
	private String nombre;
	
	private int vitalidad;
	
	protected Posicion pos;
	
	public Personaje(String nombre, int vitalidad, double x, double y) {
		super();
		this.nombre = nombre;
		this.vitalidad = vitalidad;
		this.pos = new Posicion(x, y);
	}
	
	public Personaje(String nombre, int vitalidad) {
		super();
		this.nombre = nombre;
		this.vitalidad = vitalidad;
		this.pos = new Posicion();
	}

	abstract boolean ataca(Personaje p) ; 
	
	void recibeDanio(int cantidad) {
		this.vitalidad = Math.max(this.vitalidad - cantidad, 0);
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	public int getVitalidad() {
		return this.vitalidad;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", vitalidad=" + vitalidad + ", pos=" + pos;
	}
}
