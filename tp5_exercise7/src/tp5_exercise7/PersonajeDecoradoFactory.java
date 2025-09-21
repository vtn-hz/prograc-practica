package tp5_exercise7;

import tp5_exercise7.personajes.*;
import tp5_exercise7.decorators.*;

public class PersonajeDecoradoFactory {

	public PersonajeDecoradoFactory() {}
	
	public IPersonaje create (String pj, String dctr) {
		IPersonaje personaje = this.createPersonaje(pj);
		return (IPersonaje) this.createDecorator(personaje, dctr);
	}
	
	/**
	 * <b>pre-cond:</b> el personaje existe
	 */
	private IPersonaje createPersonaje( String pj ) {
		
		// may be HashTable<String, IPersonaje>
		IPersonaje personaje = null;
		
		switch( pj ) {
			case "mago": 		
				personaje = new Mago();
				break;
			case "elfo": 		
				personaje = new Elfo(); 	
				break;
			case "hechicera": 	
				personaje = new Hechicera();
				break;
			case "dragon": 		
				personaje = new Dragon(); 	
				break;
			case "guerrero": 	
				personaje = new Guerrero(); 
				break;
		}
		
		return personaje;
	}
	
	/**
	 * <b>pre-cond:</b> el decorador existe
	 */
	private IPersonaje createDecorator( IPersonaje personaje, String dcrt ) {
		
		// may be HashTable<String, Decorator>
		Decorator decorado = null;
		
		switch( dcrt ) {
			case "tierra": 		
				decorado = new DecoratorTierra( personaje ); 	
				break;
			case "aire": 		
				decorado = new DecoratorAire( personaje ); 	
				break;
			case "agua": 	
				decorado = new DecoratorAgua( personaje ); 
				break;
			case "fuego": 		
				decorado = new DecoratorFuego( personaje ); 	
				break;
		}
		
		return decorado;
	}

}
