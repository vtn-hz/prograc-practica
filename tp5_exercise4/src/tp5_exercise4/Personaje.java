package tp5_exercise4;

public class Personaje implements IMovible {
	private IMovible posicion;
	
	public Personaje(double x, double y) {
		this.posicion = new Posicion(x, y);
	}

	@Override
	public double getPosx() {
		return this.posicion.getPosx();
	}

	@Override
	public double getPosy() {
		return this.posicion.getPosy();
	}

	@Override
	public void setXY(double x, double y) {
		this.posicion.setXY(x, y);
	}

	@Override
	public void incrementaPos(double valX, double valY) {
		this.posicion.incrementaPos(valX, valY);
	}

	@Override
	public double distancia(IMovible movible) {
		return this.posicion.distancia(movible);
	}

}
