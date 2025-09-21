package tp5_exercise7.decorators;

import tp5_exercise7.Decorator;
import tp5_exercise7.IPersonaje;

public class DecoratorTierra extends Decorator {

	public DecoratorTierra(IPersonaje personaje) {
		super(personaje);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArmadura() {
		return this.getPersonaje().getArmadura()*1.25;
	}

	@Override
	public double getAtaqueCorto() {
		return this.getPersonaje().getAtaqueCorto()*0.8;
	}

	@Override
	public double getAtaqueDistante() {
		return this.getPersonaje().getAtaqueDistante()*0.7;
	}
	
	
	@Override
	public String toString() {
		return "DecoratorTierra " + this.getPersonaje() + " [" + 
				 "armadura:" + this.getArmadura() + ", " +
				 "ataqueCorto: " + this.getAtaqueCorto() + ", " +
				 "ataqueDistante: " + this.getAtaqueDistante() +
		"]";
	}
}
