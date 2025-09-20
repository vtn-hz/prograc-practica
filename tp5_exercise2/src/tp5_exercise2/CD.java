package tp5_exercise2;

import java.util.ArrayList;

public class CD extends Comparable implements IPrestable {
	
	private String codigo;
	
	private String titulo; 
	
	private String interprete;
	
	private ArrayList<Cancion> listaCanciones; 
	
	private boolean prestadoStatus;
	
	public CD(String codigo, String titulo, String interprete) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.interprete = interprete;
		this.listaCanciones = new ArrayList<Cancion>();
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
	
	public String getTitulo() {
		return titulo;
	}

	public String getInterprete() {
		return interprete;
	}
	
	public void addCancion(Cancion cancion) {
		this.listaCanciones.add(cancion);
	}
	
	public int compare ( Comparable compared ) {
		int result = 0;
		CD comparedCd = (CD) compared;
		
		result = this.interprete.compareTo(comparedCd.interprete);
		if ( result == 0 ) {
			result = this.titulo.compareTo(comparedCd.titulo);
		}
		
		return result;
	}

	@Override
	public String toString() {
		return "CD [codigo=" + codigo + ", titulo=" + titulo + ", interprete=" + interprete + ", listaCanciones="
				+ listaCanciones + "]";
	}
}
