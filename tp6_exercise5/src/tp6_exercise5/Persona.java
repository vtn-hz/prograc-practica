package tp6_exercise5;

public class Persona implements Comparable<Persona>, Cloneable {
	
	private int dni;
	
	private Domicilio domicilio;
	
	private Animal mascota;
	
	private String nombre;
	
	
	
	public Persona() {
		super();
	}

	
	public Persona(int dni, Domicilio domicilio, String nombre) {
		super();
		this.dni = dni;
		this.domicilio = domicilio;
		this.nombre = nombre;
	}



	public Persona(int dni, Domicilio domicilio, Animal mascota, String nombre) {
		super();
		this.dni = dni;
		this.domicilio = domicilio;
		this.mascota = mascota;
		this.nombre = nombre;
	}
	
	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public Domicilio getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}


	public Animal getMascota() {
		return mascota;
	}


	public String getNombre() {
		return nombre;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Persona pcloned = (Persona) super.clone();
		pcloned.domicilio = (Domicilio) this.domicilio.clone();
		pcloned.mascota = (Animal) this.mascota.clone();
		
		return pcloned;
	}

	
	@Override
	public int compareTo(Persona persona) {
		if (persona.dni == this.dni) {
			return 0;
		}
		
		return persona.dni > this.dni ? -1 : 1;
	}
	
	
	
	

}
