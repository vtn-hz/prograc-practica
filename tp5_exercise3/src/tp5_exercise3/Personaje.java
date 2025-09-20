package tp5_exercise3;

public abstract class Personaje extends Unidad implements IMovible {

	public Personaje(String equipo, int costo, int energia, int x, int y) {
		super(equipo, costo, energia, x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public void mover(int x, int y) {
		this.setX( this.getX() + x );
		this.setY( this.getY() + y );
	}
}
