package tp5_exercise7.personajes;

import tp5_exercise7.Personaje;

public class Elfo extends Personaje {

	private static double ARMADURA = 1000;
	
	private static double ATAQUE_CORTO = 20;
	
	private static double ATAQUE_DISTANTE = 100;
	
	public Elfo() {
		super(ARMADURA, ATAQUE_CORTO, ATAQUE_DISTANTE);
	}

	@Override
	public String toString() {
		return "Elfo";
	}	
}
