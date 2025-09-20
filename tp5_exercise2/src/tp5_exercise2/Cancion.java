package tp5_exercise2;

public class Cancion {
	private int nroPista;
	
	private String titulo;
	
	private int duracionM;
	
	private int duracionS;

	public Cancion(int nroPista, String titulo, int duracionM, int duracionS) {
		super();
		this.nroPista = nroPista;
		this.titulo = titulo;
		this.duracionM = duracionM;
		this.duracionS = duracionS;
	}

	public int getNroPista() {
		return nroPista;
	}

	public void setNroPista(int nroPista) {
		this.nroPista = nroPista;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracionM() {
		return duracionM;
	}

	public void setDuracionM(int duracionM) {
		this.duracionM = duracionM;
	}

	public int getDuracionS() {
		return duracionS;
	}

	public void setDuracionS(int duracionS) {
		this.duracionS = duracionS;
	}
}
