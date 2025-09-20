package tp5_exercise5;

public class Juguetero extends Artesano {

	public Juguetero(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String trabajar(Material mat) {
		return mat.esTrabajado(this);
	}

	@Override
	public String trabajarMadera() {
		return this.getNombre() + " fabrico un muñequito de";
	}

	@Override
	public String trabajarMetal() {
		return this.getNombre() + " fabrico un autito de";
	}
}
