package tp5_exercise7.personajes;

import tp5_exercise7.Personaje;

public class Dragon extends Personaje {

	private static double ARMADURA = 10000;
	
	private static double ATAQUE_CORTO = 500;
	
	private static double ATAQUE_DISTANTE = 200;
	
	public Dragon() {
		super(ARMADURA, ATAQUE_CORTO, ATAQUE_DISTANTE);
	}

	@Override
	public String toString() {
		return "Dragon";
	}
	
	
}
