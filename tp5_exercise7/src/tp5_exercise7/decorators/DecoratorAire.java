package tp5_exercise7.decorators;

import tp5_exercise7.Decorator;
import tp5_exercise7.IPersonaje;

public class DecoratorAire extends Decorator {

	public DecoratorAire(IPersonaje personaje) {
		super(personaje);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArmadura() {
		return this.getPersonaje().getArmadura()*0.9;
	}

	@Override
	public double getAtaqueCorto() {
		return this.getPersonaje().getAtaqueCorto()*1.2;
	}

	@Override
	public double getAtaqueDistante() {
		return this.getPersonaje().getAtaqueDistante()*1.1;
	}
	
	public void invocarHuracan () {
		System.out.println("Invocar huracan...");
	}
	
	@Override
	public String toString() {
		return "DecoratorAire " + this.getPersonaje() + " [" + 
				 "armadura:" + this.getArmadura() + ", " +
				 "ataqueCorto: " + this.getAtaqueCorto() + ", " +
				 "ataqueDistante: " + this.getAtaqueDistante() +
		"]";
	}
}
