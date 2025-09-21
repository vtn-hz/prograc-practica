package main;

import tp5_exercise7.*;

import tp5_exercise7.decorators.DecoratorFuego;
import tp5_exercise7.decorators.DecoratorAire;


public class Main {

    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE DECORADORES DE VIENTO (AIRE) Y FUEGO ===\n");
        
        PersonajeDecoradoFactory factory = new PersonajeDecoradoFactory();
        IPersonaje magoAire = factory.create("mago", "aire");
        IPersonaje dragonFuego = factory.create("dragon", "fuego");
        
        ((DecoratorFuego) dragonFuego).incendiar();
        ((DecoratorAire) magoAire).invocarHuracan();
        
        
        System.out.println("\n--- Elegir Adversario ---");
        
        System.out.println("El mago de aire elige un adversario:");
        IPersonaje adversario1 = magoAire.eligeAdversario();
        System.out.println("Adversario elegido: " + adversario1);
        
        System.out.println("\nEl dragón de fuego elige un adversario:");
        IPersonaje adversario2 = dragonFuego.eligeAdversario();
        System.out.println("Adversario elegido: " + adversario2);
        
        // === PRUEBA 5: Mostrar todo el mazo ===
        System.out.println("\n--- PRUEBA 5: Contenido completo del Mazo ---");
        Mazo mazo = Mazo.getInstance();
        System.out.println(mazo.toString());
        
        System.out.println("\n=== FIN DE LAS PRUEBAS ===");
    }

}