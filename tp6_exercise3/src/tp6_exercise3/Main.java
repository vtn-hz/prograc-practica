package tp6_exercise3;

import tp6_exercise3.exceptions.*;

public class Main {

	
	public static void main(String[] args) {
	    Surtidor surtidor = new Surtidor();
	
	    System.out.println("=== Estado inicial del surtidor ===");
	    System.out.println("Diesel: " + surtidor.getCantidadDiesel());
	    System.out.println("Premium: " + surtidor.getCantidadPremium());
	    System.out.println("Super: " + surtidor.getCantidadSuper());
	
	    System.out.println("\n=== Pruebas de carga ===");
	
	    try {
	        System.out.println("\nIntentando cargar 5000 litros de diesel...");
	        surtidor.cargaCombustible("diesel", 5000);
	        System.out.println("Carga exitosa. Diesel restante: " + surtidor.getCantidadDiesel());
	    } catch (CargaInvalidaException e) {
	        mostrarError(e);
	    }
	
	    try {
	        System.out.println("\nIntentando cargar -100 litros de premium...");
	        surtidor.cargaCombustible("premium", -100);
	    } catch (CargaInvalidaException e) {
	        mostrarError(e);
	    }
	
	    try {
	        System.out.println("\nIntentando cargar 25000 litros de super...");
	        surtidor.cargaCombustible("super", 25000);
	    } catch (CargaInvalidaException e) {
	        mostrarError(e);
	    }
	
	    try {
	        System.out.println("\nIntentando cargar 1000 litros de kerosene...");
	        surtidor.cargaCombustible("kerosene", 1000);
	    } catch (CargaInvalidaException e) {
	        mostrarError(e);
	    }
	
	    System.out.println("\n=== Estado final del surtidor ===");
	    System.out.println("Diesel: " + surtidor.getCantidadDiesel());
	    System.out.println("Premium: " + surtidor.getCantidadPremium());
	    System.out.println("Super: " + surtidor.getCantidadSuper());
	}
	
	private static void mostrarError(CargaInvalidaException e) {
	    DatoCargaInvalida d = e.getDatoCargaInvalida();
	    System.out.println("Error: " + e.getMessage());
	    System.out.println("  Combustible: " + d.getCombustible());
	    System.out.println("  Cantidad solicitada: " + d.getCantidadRequerida());
	    System.out.println("  Cantidad disponible: " + d.getCantidadDisponible());
	}


}
