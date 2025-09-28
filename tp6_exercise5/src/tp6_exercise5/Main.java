package tp6_exercise5;

public class Main {
	public static void main(String[] args) {
		try {
			// Crear domicilio y mascota
			Domicilio dom = new Domicilio("San Martín", 1234);
			Perro perro = new Perro(12, "Firulais");
			// Crear persona original
			Persona p1 = new Persona(12345678, dom, perro, "Valentino");

			// Clonar persona
			Persona p2 = (Persona) p1.clone();

			// Mostrar resultados
			System.out.println("Persona original: " + p1.getNombre() + " - " + p1.getDomicilio() + " - Mascota: "
					+ p1.getMascota().getNombre());
			System.out.println("Persona clonada : " + p2.getNombre() + " - " + p2.getDomicilio() + " - Mascota: "
					+ p2.getMascota().getNombre());
			
			// Verificar que los objetos sean distintos
			System.out.println("\n¿Mismo objeto Persona? " + (p1 == p2));
			System.out.println("¿Mismo domicilio? " + (p1.getDomicilio() == p2.getDomicilio()));
			System.out.println("¿Misma mascota? " + (p1.getMascota() == p2.getMascota()));

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
