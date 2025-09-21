package tp5_exercise6;

import java.lang.Math;

public class Guerrero extends Personaje implements IHechizable {

	static final int VIDA_INICIAL = 800;
	
	static final int DISTANCIA_ATAQUE = 5;
	
	static final int DANIO = 10;
	
	private int armadura;
	
	public Guerrero(String nombre, int vitalidad, int armadura, double x, double y) {
		super(nombre, VIDA_INICIAL, x, y);
		this.armadura = armadura;
	}

	public Guerrero(String nombre, int vitalidad, int armadura) {
		super(nombre, vitalidad);
		this.armadura = armadura;
	}

	@Override
	public boolean ataca(Personaje p) {
		boolean atackSuccess = false;
		if (this.distancia(p) < DISTANCIA_ATAQUE) {
			p.recibeDanio(DANIO);
			atackSuccess = true;
		}
		
		return atackSuccess;
	}
	
	@Override
	public void recibeDanio(int danio) {
		int danioRestante = Math.max(danio - this.armadura, 0);
		this.armadura = Math.max(this.armadura - danio, 0);
		
		super.recibeDanio(danioRestante);
	}
	
	@Override
	public void serBendecido() {
		this.armadura += 200;
	}

	@Override
	public void serMaldito() {
		this.armadura -= 200;
		this.armadura = Math.max(this.armadura, 0);
	}

	

	@Override
	public String toString() {
		return "Guerrero [armadura=" + armadura + ", " + super.toString() + "]";
	}
}
