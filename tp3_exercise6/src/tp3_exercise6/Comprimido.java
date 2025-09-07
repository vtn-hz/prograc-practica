package tp3_exercise6;

public class Comprimido extends Single {

	private FileSystemEntity compresed;
	
	private double tasa;
	
	public Comprimido(String fecha_creacion, String nombre, FileSystemEntity compresed, Double tasa) {
		super(fecha_creacion, nombre);
		this.compresed = compresed;
		this.tasa = tasa;
	}

	@Override
	public double getTamano() {
		return this.compresed.getTamano()*tasa;
	}
		
	public void showContent () {
		this.compresed.print();
	}
	
	@Override	
	public void print () {
		super.print();
		System.out.print(" [%" + this.tasa*100 + "]");
	}
}
