package tp5_exercise7.decorators;

import tp5_exercise7.Decorator;
import tp5_exercise7.IPersonaje;

public class DecoratorFuego extends Decorator {

	public DecoratorFuego(IPersonaje personaje) {
		super(personaje);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArmadura() {
		return this.getPersonaje().getArmadura()*0.5;
	}

	@Override
	public double getAtaqueCorto() {
		return this.getPersonaje().getAtaqueCorto()*1.8;
	}

	@Override
	public double getAtaqueDistante() {
		return this.getPersonaje().getAtaqueDistante()*1.7;
	}
	
	public void incendiar () {
		System.out.println("Incendiar...");
	}
	
	
	@Override
	public String toString() {
		return "DecoratorFuego " + this.getPersonaje() + " [" + 
				 "armadura:" + this.getArmadura() + ", " +
				 "ataqueCorto: " + this.getAtaqueCorto() + ", " +
				 "ataqueDistante: " + this.getAtaqueDistante() +
		"]";
	}
}
