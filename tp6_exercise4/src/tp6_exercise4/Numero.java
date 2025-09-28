package tp6_exercise4;

public class Numero implements Cloneable {
	int dato;

	public Numero(int dato) {
		super();
		this.dato = dato;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	@Override
	public String toString() {
		return "Numero [dato=" + dato + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
