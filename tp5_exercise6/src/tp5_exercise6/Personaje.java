package tp5_exercise6;



public abstract class Personaje implements IMovible {
	
	private IMovible posicion;
	
	private String nombre;
	
	private int vitalidad;

	
	public Personaje(String nombre, int vitalidad, double x, double y) {
		super();
		this.nombre = nombre;
		this.vitalidad = vitalidad;
		this.posicion = new Posicion(x, y);
	}
	
	public Personaje(String nombre, int vitalidad) {
		super();
		this.nombre = nombre;
		this.vitalidad = vitalidad;
		this.posicion = new Posicion();
	}
	
	abstract public boolean ataca(Personaje p) ; 
	
	void recibeDanio(int cantidad) {
		this.vitalidad = Math.max(this.vitalidad - cantidad, 0);
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	public int getVitalidad() {
		return this.vitalidad;
	}
	
	public void setVitalidad(int vitalidad) {
		this.vitalidad = vitalidad;
	}

	@Override
	public double getPosx() {
		return this.posicion.getPosx();
	}

	@Override
	public double getPosy() {
		return this.posicion.getPosy();
	}

	@Override
	public void setXY(double x, double y) {
		this.posicion.setXY(x, y);
	}

	@Override
	public void incrementaPos(double valX, double valY) {
		this.posicion.incrementaPos(valX, valY);
	}

	@Override
	public double distancia(IMovible movible) {
		return this.posicion.distancia(movible);
	}
	
	@Override
	public String toString() {
		return "nombre=" + nombre + ", vitalidad=" + vitalidad + ", posicion=" + posicion;
	}
}
