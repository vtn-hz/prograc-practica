package tp5_exercise7;

public abstract class Personaje implements IPersonaje {
	
	private double armadura;
	
	private double ataqueCorto;
	
	private double ataqueDistante;

	public Personaje(double armadura, double ataqueCorto, double ataqueDistante) {
		super();
		this.armadura = armadura;
		this.ataqueCorto = ataqueCorto;
		this.ataqueDistante = ataqueDistante;
	}
	
	@Override
	public double getArmadura() {
		return armadura;
	}

	@Override
	public double getAtaqueCorto() {
		return ataqueCorto;
	}

	@Override
	public double getAtaqueDistante() {
		return ataqueDistante;
	}
	
	public IPersonaje eligeAdversario() {
		Mazo mazo = Mazo.getInstance();
		return mazo.eligeAdversario(this);
	} 

}
