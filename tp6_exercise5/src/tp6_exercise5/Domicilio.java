package tp6_exercise5;

public class Domicilio implements Cloneable {
	private String calle;
	
	private int numero;
	
	public Domicilio() {}

	public Domicilio(String calle, int numero) {
		super();
		this.calle = calle;
		this.numero = numero;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public Object clone () throws CloneNotSupportedException {
		return super.clone();
	}
	

	@Override
	public String toString() {
		return "Domicilio [calle=" + calle + ", numero=" + numero + "]";
	}
	
}
