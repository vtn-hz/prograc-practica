package tp5_exercise3;

public abstract class Edificio extends Unidad implements IConstruible {
	

	private int tiempoConstruccion;

	public Edificio(String equipo, int costo, int energia, int x, int y, int tiempoConstruccion) {
		super(equipo, costo, energia, x, y);
		this.tiempoConstruccion = tiempoConstruccion;
	}


	@Override
	public int getTiempoConstruccion() {
		return this.tiempoConstruccion;
	}	
}
