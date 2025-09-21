package tp5_exercise7;

import java.util.Random;

public class Mazo {
	
	private static Mazo _instance;
	
	private PersonajeDecoradoFactory personajeFactory;
	
	private String[] personajes;
	
	private String[] tipos;
	
	private IPersonaje[] cartas;
	
	private Random random;
	
	private Mazo() {
		this.cartas = new IPersonaje[ 20 ];
		
		this.personajes = new String[]{
			"mago", "elfo", "hechicera",
			"dragon", "guerrero"
		};
		
		this.tipos = new String[]{
			"tierra", "aire",
			"agua", "fuego"
		};
		
		this.random = new Random();
		this.personajeFactory = new PersonajeDecoradoFactory();
		this.init();
	}
	
	private void init () {
		for(int i=0 ; i<5; i++) {
			for (int j=0 ; j<4 ; j++) {
				this.cartas[4 * i + j] = 
						this.personajeFactory.create(
								this.personajes[i], 
								this.tipos[j]
						);
			} 
		}
	}
	
	public static Mazo getInstance() {
		if (Mazo._instance == null) {
			Mazo._instance = new Mazo();
		}
		
		return Mazo._instance;
	}
	
	public IPersonaje eligeAdversario( IPersonaje excluded ) {
		int indice = this.random.nextInt(20);
		IPersonaje selected = this.cartas[indice];
		
		return selected != excluded 
				? selected
				: this.eligeAdversario(excluded); 
	}

	@Override
	public String toString() {
		String cards = ""; 
		for (int i=0 ; i<20; i++)
			cards += "\t" + this.cartas[i] + "\n";
		
		return "Mazo [\n" + cards +"]";
	}

	
}
