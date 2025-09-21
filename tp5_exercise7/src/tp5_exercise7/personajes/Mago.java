package tp5_exercise7.personajes;

import tp5_exercise7.Personaje;

public class Mago extends Personaje {

	private static double ARMADURA = 500;
	
	private static double ATAQUE_CORTO = 50;
	
	private static double ATAQUE_DISTANTE = 70;
	
	public Mago() {
		super(ARMADURA, ATAQUE_CORTO, ATAQUE_DISTANTE);
	}
	
	@Override
	public String toString() {
		return "Mago";
	}	
}
