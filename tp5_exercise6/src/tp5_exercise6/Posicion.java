package tp5_exercise6;

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
		this.x += x;
		this.y += y;
		
	}

	@Override
	public double distancia(IMovible movible) {
		double distance2 =	Math.pow(this.getPosx() - this.x, 2) + 
							Math.pow(this.getPosy() - this.y, 2);
		return Math.sqrt(distance2);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
