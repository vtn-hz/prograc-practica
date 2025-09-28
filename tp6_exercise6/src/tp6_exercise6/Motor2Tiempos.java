package tp6_exercise6;

public class Motor2Tiempos extends Motor {
	
	private int schedule; 
	
	public Motor2Tiempos() {
		// TODO Auto-generated constructor stub
	}

	public Motor2Tiempos(String fabricante, String nSerie, double potencia, int schedule) {
		super(fabricante, nSerie, potencia);
		this.schedule = schedule;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Motor2Tiempos clone() throws CloneNotSupportedException {
	    return (Motor2Tiempos) super.clone();
	}
	
	@Override
	public String toString() {
		return "Motor2Tiempos [schedule=" + schedule + "]";
	}
}
