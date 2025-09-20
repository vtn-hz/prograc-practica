package tp5_exercise3;

public abstract class Unidad implements IPosicionable {
	
	private String equipo;
	
	private int costo;
	
	private int energia;
	
	private int x;
	
	private int y;
	
	public Unidad(String equipo, int costo, int energia, int x, int y) {
		super();
		this.equipo = equipo;
		this.costo = costo;
		this.energia = energia;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public abstract void recibeDano(int cantidad);
}
