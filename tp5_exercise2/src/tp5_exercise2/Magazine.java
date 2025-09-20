package tp5_exercise2;

public class Magazine implements IPrestable {
	
	private int numero;
	
	private boolean prestadoStatus;

	public Magazine(int numero) {
		super();
		this.numero = numero;
	}

	@Override
	public void prestar() {
		this.prestadoStatus = true;
	}

	@Override
	public void devolver() {
		this.prestadoStatus = false;
	}

	@Override
	public boolean isPrestado() {
		return this.prestadoStatus;
	}

	@Override
	public String toString() {
		return "Magazine [numero=" + numero + "]";
	}

}
