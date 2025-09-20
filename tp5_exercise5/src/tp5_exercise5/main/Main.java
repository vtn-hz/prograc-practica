package tp5_exercise5.main;

import tp5_exercise5.*;

public class Main {
	
    public static void main(String[] args) {
		Material cobre=new Metal("cobre","rojo");
		Material pino=new Madera("pino","amarillo");
		Artesano a1=new Juguetero("Juan");
		Artesano a2=new Joyero("Pedro");
		System.out.println(a1.trabajar(cobre));
		System.out.println(a1.trabajar(pino));
		System.out.println(a2.trabajar(cobre));
		System.out.println(a2.trabajar(pino));
	}
}
