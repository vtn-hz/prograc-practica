package tp5_exercise7.decorators;

import tp5_exercise7.Decorator;
import tp5_exercise7.IPersonaje;

public class DecoratorAgua extends Decorator {

	public DecoratorAgua(IPersonaje personaje) {
		super(personaje);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArmadura() {
		return this.getPersonaje().getArmadura()*0.85;
	}

	@Override
	public double getAtaqueCorto() {
		return this.getPersonaje().getAtaqueCorto()*1.2;
	}

	@Override
	public double getAtaqueDistante() {
		return this.getPersonaje().getAtaqueDistante();
	}

	@Override
	public String toString() {
		return "DecoratorAgua " + this.getPersonaje() + " [" + 
				 "armadura:" + this.getArmadura() + ", " +
				 "ataqueCorto: " + this.getAtaqueCorto() + ", " +
				 "ataqueDistante: " + this.getAtaqueDistante() +
		"]";
	}
}
