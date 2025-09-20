package tp5_exercise3;

public class Medico extends Personaje {

	public Medico(String equipo, int x, int y) {
		super(equipo, 100, 500, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void recibeDano(int cantidad) {
		double resultEnergy = this.getEnergia() - 1.5*cantidad; 
		this.setEnergia( (int) resultEnergy );
	}

}
