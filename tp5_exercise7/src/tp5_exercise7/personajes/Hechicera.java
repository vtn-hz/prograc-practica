package tp5_exercise7.personajes;

import tp5_exercise7.Personaje;

public class Hechicera extends Personaje {

	private static double ARMADURA = 1000;
	
	private static double ATAQUE_CORTO = 70;
	
	private static double ATAQUE_DISTANTE = 50;
	
	public Hechicera() {
		super(ARMADURA, ATAQUE_CORTO, ATAQUE_DISTANTE);
	}
	
	@Override
	public String toString() {
		return "Hechicera";
	}	
}
