package tp5_exercise5;

public class Metal extends Material {
	
	private String nombre;

	public Metal(String nombre, String color) {
		super(color);
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String esTrabajado(Artesano art) {
		return art.trabajarMetal() + " " + this;
	}
	
	@Override
	public String toString() {
		return  this.getNombre() + " " + this.getColor();
	}
	
}
