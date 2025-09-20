package tp5_exercise5;

public abstract class Artesano {
	
	private String nombre;
	
	public Artesano(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	abstract public String trabajar (Material mat);
	
	abstract public String trabajarMadera ();
	
	abstract public String trabajarMetal  ();
	
}
