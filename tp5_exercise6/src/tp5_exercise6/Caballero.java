package tp5_exercise6;

public class Caballero extends Personaje {

	static final int VIDA_INICIAL = 500;
	
	static final int DISTANCIA_ATAQUE = 10;
	
	static final int DANIO = 10;
	
	public Caballero(String nombre, int vitalidad, double x, double y) {
		super(nombre, VIDA_INICIAL, x, y);
	}

	public Caballero(String nombre, int vitalidad) {
		super(nombre, vitalidad);
	}

	@Override
	boolean ataca(Personaje p) {
		boolean atackSuccess = false;
		if (this.distancia(p) < DISTANCIA_ATAQUE) {
			p.recibeDanio(DANIO);
			atackSuccess = true;
		}
		
		return atackSuccess;
	}

	@Override
	public String toString() {
		return "Caballero [" + super.toString() + "]";
	}
}
