package tp3_exercise5;

import java.lang.Math;

public class AutomovilManual extends Automovil {

	public AutomovilManual(String patente, double velmax) {
		super(patente, velmax);
	}

	public AutomovilManual(String patente) {
		super(patente);
	}

	@Override
	public void acelerar(double vel) {
		if (vel < 0) {
			return;
		}
		
		this.velocidad = Math.min(this.velocidad + vel, this.velocidadMaxima); 
	}

	@Override
	public void frenar(double vel) {
		if (vel < 0) {
			return;
		}
		
		this.velocidad = Math.max(this.velocidad - vel, 0); 
	}
	
	
}
