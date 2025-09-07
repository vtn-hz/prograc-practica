package tp3_exercise6;

public abstract class Single extends FileSystemEntity {

	public Single(String fecha_creacion, String nombre) {
		super(fecha_creacion, nombre);
	}
	
	@Override 
	public void print () {
		System.out.print( this.getNombre() + " (" + this.getTamano() + " kb)");
	}
}
