package tp3_exercise5;

public abstract class Automovil {

	private String patente;
	
	protected double velocidad;
	
	static private double VELOCIDAD_MAXIMA = 160;
	
	protected double velocidadMaxima;
	
	protected int marcha;
	
	public Automovil(String patente, double velmax) {
		this.patente = patente;
		this.velocidadMaxima = velmax;
	}
	
	public Automovil(String patente) {
		this.patente = patente;
		this.velocidadMaxima = Automovil.VELOCIDAD_MAXIMA;
	}
	
	public int getMarcha() {
		return marcha;
	}

	public void setMarcha(int marcha) {
		this.marcha = marcha;
	}

	public String getPatente() {
		return patente;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}
	
	public abstract void acelerar (double vel) ;
	
	public abstract void frenar (double vel) ;

	@Override
	public String toString() {
		return "Automovil [patente=" + patente + ", velocidad=" + velocidad + ", marcha=" + marcha + "]";
	}
}
