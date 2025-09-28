package tp6_exercise4;

public class ConjuntoNumeros implements Cloneable {
		
	private String nombre;

	private int largo;
	
	private int cantidad = 0;
	
	private Numero[] celda;
	
	public ConjuntoNumeros(String nombre, int largo) {
		super();
		this.largo = largo;
		this.nombre = nombre;
		this.celda = new Numero[30];
	}

	public String getNombre() {
		return nombre;
	}

	public int getLargo() {
		return largo;
	}

	public Numero[] getCelda() {
		return celda;
	}
	
	public void addNumero (Numero numero) {
		if (this.cantidad == this.largo) {
			// ... throw some exception
		}
		
		this.celda[this.cantidad++] = numero;
	}

	@Override
	public String toString() {
		return "ConjuntoNumeros [nombre=" + nombre + ", largo=" + largo + "]";
	}
	
	@Override 
	public Object clone () throws CloneNotSupportedException {
		ConjuntoNumeros conjunto = (ConjuntoNumeros) super.clone();
		conjunto.celda = this.celda.clone();
		
		for(int i=0 ; i<this.cantidad; i++) {
			conjunto.celda[i] = (Numero) this.celda[i].clone();
		}
		
		return conjunto;
	}
	
}
