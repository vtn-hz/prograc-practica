package tp5_exercise6;

public class Arquero extends Personaje {
	
	static final int VIDA_INICIAL = 500;
	
	private int cantidadFlechas;
	
	public Arquero(String nombre, int vitalidad, double x, double y) {
		super(nombre, VIDA_INICIAL, x, y);
		this.cantidadFlechas = 20;
	}

	public Arquero(String nombre, int vitalidad) {
		super(nombre, vitalidad);
		this.cantidadFlechas = 20;
	}

	@Override
	boolean ataca(Personaje p) {
		boolean atackSuccess = false;
		int danio = 5;
		int distancia = 5;
		
		if (this.hasFlechas()) {
			danio = 15;
			distancia = 100;
		}
		
		
		if (this.distancia(p) < distancia) {
			p.recibeDanio(danio);
			atackSuccess = true;
		}
		
		return atackSuccess;
	}
	
	private boolean hasFlechas () {
		return this.cantidadFlechas > 0;
	}

	@Override
	public String toString() {
		return "Arquero [cantidadFlechas=" + cantidadFlechas + ", " + super.toString() + "]";
	}
}
