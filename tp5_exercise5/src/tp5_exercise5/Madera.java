package tp5_exercise5;

public class Madera extends Material {
	
	private String tipo;

	public Madera(String tipo, String color) {
		super(color);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public String esTrabajado(Artesano art) {
		return art.trabajarMadera() + " " + this;
	}

	@Override
	public String toString() {
		return  this.getTipo() + " " + this.getColor();
	}
	
	
	
}	
