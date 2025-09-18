package tp4_exercise8.model;

public class Posicion {
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

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	void incrementarPos(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	
	public double calcDistancia(Posicion p) {
		double distance2 = Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2);
		return Math.sqrt(distance2);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	

}
