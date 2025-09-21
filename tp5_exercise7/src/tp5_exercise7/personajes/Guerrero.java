package tp5_exercise7.personajes;

import tp5_exercise7.Personaje;

public class Guerrero extends Personaje {

	private static double ARMADURA = 1500;
	
	private static double ATAQUE_CORTO = 100;
	
	private static double ATAQUE_DISTANTE = 100;
	
	public Guerrero() {
		super(ARMADURA, ATAQUE_CORTO, ATAQUE_DISTANTE);
	}
	
	@Override
	public String toString() {
		return "Guerrero";
	}	
}
