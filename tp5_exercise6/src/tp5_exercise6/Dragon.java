package tp5_exercise6;

public class Dragon extends Personaje implements IHechizable {

	static final int VIDA_INICIAL = 1000;
	
	static final int DISTANCIA_ATAQUE = 50;
	
	private int poderFuego;
	
	public Dragon(String nombre, int vitalidad, double x, double y) {
		super(nombre, VIDA_INICIAL, x, y);
		this.poderFuego = 100;
	}

	public Dragon(String nombre, int vitalidad) {
		super(nombre, vitalidad);
	}

	@Override
	public boolean ataca(Personaje p) {
		boolean atackSuccess = false;
		if (this.distancia(p) < DISTANCIA_ATAQUE) {
			p.recibeDanio(this.poderFuego);
			atackSuccess = true;
		}
		
		return atackSuccess;
	}
	
	@Override
	public void recibeDanio(int danio) {
		super.recibeDanio((int) (danio / 2));
	}
	
	@Override
	public void serBendecido() {
		this.poderFuego *= 1.4;
		this.setVitalidad( this.getVitalidad() + 250 );
	}

	@Override
	public void serMaldito() {
		this.poderFuego *= 0.7;
		this.setVitalidad( (int) (this.getVitalidad() * 0.8));
	}

	@Override
	public String toString() {
		return "Caballero [" + super.toString() + "]";
	}
}
