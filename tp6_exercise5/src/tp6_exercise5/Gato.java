package tp6_exercise5;

public class Gato extends Animal {

	public Gato() {
		// TODO Auto-generated constructor stub
	}

	public Gato(int esperanzavida, String nombre) {
		super(esperanzavida, nombre);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
