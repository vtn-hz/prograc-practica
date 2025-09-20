package tp5_exercise3;

public class Cuartel extends Edificio {

	public Cuartel(String equipo, int x, int y, int tiempoConstruccion) {
		super(equipo, 500, 3000, x, y, tiempoConstruccion);
	}

	@Override
	public void recibeDano(int cantidad) {
		double resultEnergy = this.getEnergia() - 0.5*cantidad; 
		this.setEnergia( (int) resultEnergy );
	}
}
