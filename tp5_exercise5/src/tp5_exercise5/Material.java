package tp5_exercise5;

public abstract class Material {
	private String color;

	public Material(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	} 
	
	abstract public String esTrabajado (Artesano art) ;
	
}
