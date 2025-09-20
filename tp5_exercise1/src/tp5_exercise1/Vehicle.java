package tp5_exercise1;

public abstract class Vehicle implements ISoundEmisor {
	private String patente;
	
	private String numeroChasis; 
	
	private String numeromotor;

	public Vehicle(String patente, String numeroChasis, String numeromotor) {
		super();
		this.patente = patente;
		this.numeroChasis = numeroChasis;
		this.numeromotor = numeromotor;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getNumeroChasis() {
		return numeroChasis;
	}

	public void setNumeroChasis(String numeroChasis) {
		this.numeroChasis = numeroChasis;
	}

	public String getNumeromotor() {
		return numeromotor;
	}

	public void setNumeromotor(String numeromotor) {
		this.numeromotor = numeromotor;
	}
	
	
}
