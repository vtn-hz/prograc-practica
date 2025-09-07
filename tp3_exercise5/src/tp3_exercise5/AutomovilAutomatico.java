package tp3_exercise5;

public class AutomovilAutomatico extends Automovil {
	
	private double[] marchasMap = {
	   0.0,    // Reversa (velocidad < 0)
       0.0,    // Punto muerto (velocidad = 0)
       10.0,   // Límite superior Primera (0 < v ≤ 10)
       35.0,   // Límite superior Segunda (10 < v ≤ 35)
       50.0,   // Límite superior Tercera (35 < v ≤ 50)
       90.0    // Límite superior Cuarta (50 < v ≤ 90)
	};
	
	private static double MIN_VEL = -10;
	
	private double minVel;
	
	public AutomovilAutomatico(String patente, double velmax, double minvel) {
		super(patente, velmax);
		this.minVel = minvel;
	}

	public AutomovilAutomatico(String patente) {
		super(patente);
		this.minVel = AutomovilAutomatico.MIN_VEL;
	}

	@Override
	public void acelerar(double vel) {
		if (vel < 0) {
			return;
		}
		
		this.velocidad = Math.min(this.velocidad + vel, this.velocidadMaxima);
		this.updateMarcha();
	}

	@Override
	public void frenar(double vel) {
		if (vel < 0) {
			return;
		}
		
		this.velocidad = Math.max(this.velocidad - vel, this.minVel); 
		this.updateMarcha();
	}
	
	private void updateMarcha() {
		int i = 0;

		while (
			i < this.marchasMap.length && 
			this.velocidad > this.marchasMap[i]
		) i++;
		
		this.setMarcha(i-1);
	} 
}
