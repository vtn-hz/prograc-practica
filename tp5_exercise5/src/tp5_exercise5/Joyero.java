package tp5_exercise5;

public class Joyero extends Artesano {

	public Joyero(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String trabajar(Material mat) {
		return mat.esTrabajado(this);
	}

	@Override
	public String trabajarMadera() {
		return this.getNombre() + " fabrico un par de aros de";
	}

	@Override
	public String trabajarMetal() {
		return this.getNombre() + " fabrico un anillo de";
	}

}
