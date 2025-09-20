package tp5_exercise2;

public class Book implements IPrestable {
	
	private String codigo;
	
	private String titulo;
	
	private int anioPublicacion;
	
	private boolean prestadoStatus;
	
	public Book(String codigo, String titulo, int anioPublicacion) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.anioPublicacion = anioPublicacion;
		this.prestadoStatus = false;
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
		return "Book [codigo=" + codigo + ", titulo=" + titulo + ", anioPublicacion=" + anioPublicacion + "]";
	}
}
