package tp5_exercise7;

public abstract class Decorator implements IPersonaje {
	
	private IPersonaje personaje;
	
	public Decorator( IPersonaje personaje ) {
		this.personaje = personaje;
	}
	
	public IPersonaje getPersonaje() {
		return this.personaje;
	} 
	
	public IPersonaje eligeAdversario() {
		return this.personaje.eligeAdversario();
	}

}
