package tp5_exercise4;

import java.lang.Math;

public class Posicion implements IMovible {
	
	private double x;
	
	private double y;

	public Posicion() {
		super();
	}

	public Posicion(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public double getPosx() {
		return x;
	}

	@Override
	public double getPosy() {
		return y;
	}

	@Override
	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void incrementaPos(double valX, double valY) {
		this.x += valX;
		this.y += valY;
	}

	@Override
	public double distancia(IMovible movible) {
		double xGap = movible.getPosx() - this.x;
		double yGap = movible.getPosy() - this.y;

		return Math.sqrt( Math.pow(xGap, 2) +  Math.pow(yGap, 2));
	}

}
