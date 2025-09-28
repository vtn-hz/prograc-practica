package tp6_exercise5;

public class Animal implements Cloneable {
	
	private int esperanzavida;
	
	private String nombre;

	public Animal() {
		super();
	}

	public Animal(int esperanzavida, String nombre) {
		super();
		this.esperanzavida = esperanzavida;
		this.nombre = nombre;
	}

	public int getEsperanzavida() {
		return esperanzavida;
	}

	public void setEsperanzavida(int esperanzavida) {
		this.esperanzavida = esperanzavida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();	
	}
	
	@Override
	public String toString() {
		return "Animal [esperanzavida=" + esperanzavida + ", nombre=" + nombre + "]";
	}
	
	
}
