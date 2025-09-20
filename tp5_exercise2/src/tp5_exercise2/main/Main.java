package tp5_exercise2.main;

import tp5_exercise2.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE BIBLIOTECA - PRUEBAS ===\n");
        
        // ========== PRUEBAS DE LIBROS ==========
        System.out.println("1. PRUEBAS DE LIBROS:");
        System.out.println("---------------------");
        
        // Crear libros
        Book libro1 = new Book("L001", "El Quijote", 1605);
        Book libro2 = new Book("L002", "Cien años de soledad", 1967);
        Book libro3 = new Book("L003", "1984", 1949);
        
        // Mostrar libros creados
        System.out.println("Libros creados:");
        System.out.println(libro1);
        System.out.println(libro2);
        System.out.println(libro3);
        System.out.println();
        
        // Probar estado inicial (no prestados)
        System.out.println("Estado inicial de préstamo:");
        System.out.println("¿" + libro1.toString() + " está prestado? " + libro1.isPrestado());
        System.out.println("¿" + libro2.toString() + " está prestado? " + libro2.isPrestado());
        System.out.println();
        
        // Prestar libros
        System.out.println("Prestando libros...");
        libro1.prestar();
        libro2.prestar();
        System.out.println("¿" + libro1.toString() + " está prestado? " + libro1.isPrestado());
        System.out.println("¿" + libro2.toString() + " está prestado? " + libro2.isPrestado());
        System.out.println("¿" + libro3.toString() + " está prestado? " + libro3.isPrestado());
        System.out.println();
        
        // Devolver un libro
        System.out.println("Devolviendo libro1...");
        libro1.devolver();
        System.out.println("¿" + libro1.toString() + " está prestado? " + libro1.isPrestado());
        System.out.println();
        
        // ========== PRUEBAS DE REVISTAS ==========
        System.out.println("2. PRUEBAS DE REVISTAS:");
        System.out.println("-----------------------");
        
        // Crear revistas
        Magazine revista1 = new Magazine(123);
        Magazine revista2 = new Magazine(456);
        Magazine revista3 = new Magazine(789);
        
        // Mostrar revistas
        System.out.println("Revistas creadas:");
        System.out.println(revista1);
        System.out.println(revista2);
        System.out.println(revista3);
        System.out.println();
        
        // Probar préstamo de revistas
        System.out.println("Estado inicial de préstamo de revistas:");
        System.out.println("¿" + revista1.toString() + " está prestada? " + revista1.isPrestado());
        System.out.println();
        
        System.out.println("Prestando revista1...");
        revista1.prestar();
        System.out.println("¿" + revista1.toString() + " está prestada? " + revista1.isPrestado());
        
        System.out.println("Devolviendo revista1...");
        revista1.devolver();
        System.out.println("¿" + revista1.toString() + " está prestada? " + revista1.isPrestado());
        System.out.println();
        
        // ========== PRUEBAS DE CDs ==========
        System.out.println("3. PRUEBAS DE CDs:");
        System.out.println("------------------");
        
        // Crear CDs
        CD cd1 = new CD("CD001", "Abbey Road", "The Beatles");
        CD cd2 = new CD("CD002", "Dark Side of the Moon", "Pink Floyd");
        CD cd3 = new CD("CD003", "Thriller", "Michael Jackson");
        CD cd4 = new CD("CD004", "Let It Be", "The Beatles"); // Otro CD de The Beatles para probar comparación
        
        // Crear canciones para Abbey Road
        Cancion cancion1 = new Cancion(1, "Come Together", 4, 20);
        Cancion cancion2 = new Cancion(2, "Something", 3, 3);
        Cancion cancion3 = new Cancion(3, "Maxwell's Silver Hammer", 3, 27);
        
        // Agregar canciones al CD1
        cd1.addCancion(cancion1);
        cd1.addCancion(cancion2);
        cd1.addCancion(cancion3);
        
        // Crear canciones para Dark Side of the Moon
        Cancion cancion4 = new Cancion(1, "Speak to Me", 1, 30);
        Cancion cancion5 = new Cancion(2, "Breathe", 2, 43);
        
        // Agregar canciones al CD2
        cd2.addCancion(cancion4);
        cd2.addCancion(cancion5);
        
        // Mostrar CDs
        System.out.println("CDs creados:");
        System.out.println(cd1);
        System.out.println(cd2);
        System.out.println(cd3);
        System.out.println(cd4);
        System.out.println();
        
        // Probar préstamo de CDs
        System.out.println("Probando préstamo de CDs:");
        System.out.println("¿" + cd1.getTitulo() + " está prestado? " + cd1.isPrestado());
        
        cd1.prestar();
        cd2.prestar();
        System.out.println("Después de prestar cd1 y cd2:");
        System.out.println("¿" + cd1.getTitulo() + " está prestado? " + cd1.isPrestado());
        System.out.println("¿" + cd2.getTitulo() + " está prestado? " + cd2.isPrestado());
        System.out.println("¿" + cd3.getTitulo() + " está prestado? " + cd3.isPrestado());
        
        cd1.devolver();
        System.out.println("Después de devolver cd1:");
        System.out.println("¿" + cd1.getTitulo() + " está prestado? " + cd1.isPrestado());
        System.out.println();
        
        // ========== PRUEBAS DE COMPARACIÓN DE CDs ==========
        System.out.println("4. PRUEBAS DE COMPARACIÓN DE CDs:");
        System.out.println("----------------------------------");
        
        // Crear lista de CDs para ordenar
        ArrayList<CD> listaCDs = new ArrayList<>();
        listaCDs.add(cd3); // Michael Jackson - Thriller
        listaCDs.add(cd1); // The Beatles - Abbey Road
        listaCDs.add(cd2); // Pink Floyd - Dark Side of the Moon
        listaCDs.add(cd4); // The Beatles - Let It Be
        
        System.out.println("Lista de CDs antes de ordenar:");
        for (CD cd : listaCDs) {
            System.out.println("- " + cd.getInterprete() + " - " + cd.getTitulo());
        }
        System.out.println();
        
        // Ordenar usando el método compare implementado
        System.out.println("Ordenando CDs (por intérprete y luego por título)...");
        Collections.sort(listaCDs, (cd_a, cd_b) -> cd_a.compare(cd_b));
        
        System.out.println("Lista de CDs después de ordenar:");
        for (CD cd : listaCDs) {
            System.out.println("- " + cd.getInterprete() + " - " + cd.getTitulo());
        }
        System.out.println();
        
        // ========== PRUEBAS DE COMPARACIÓN INDIVIDUAL ==========
        System.out.println("5. PRUEBAS DE COMPARACIÓN INDIVIDUAL:");
        System.out.println("--------------------------------------");
        
        System.out.println("Comparando CDs individualmente:");
        int resultado1 = cd1.compare(cd4); // The Beatles - Abbey Road vs The Beatles - Let It Be
        System.out.println("Abbey Road vs Let It Be (ambos de The Beatles): " + resultado1);
        System.out.println("(Negativo = Abbey Road va antes, Positivo = Let It Be va antes, 0 = iguales)");
        
        int resultado2 = cd1.compare(cd2); // The Beatles vs Pink Floyd
        System.out.println("The Beatles vs Pink Floyd: " + resultado2);
        
        int resultado3 = cd2.compare(cd3); // Pink Floyd vs Michael Jackson
        System.out.println("Pink Floyd vs Michael Jackson: " + resultado3);
        System.out.println();
        
        // ========== PRUEBAS CON POLIMORFISMO ==========
        System.out.println("6. PRUEBAS CON POLIMORFISMO (IPrestable):");
        System.out.println("------------------------------------------");
        
        // Crear array de elementos prestables
        IPrestable[] elementosPrestables = {
            new Book("L004", "El Principito", 1943),
            new Magazine(999),
            new CD("CD005", "Back in Black", "AC/DC")
        };
        
        System.out.println("Probando polimorfismo con IPrestable:");
        for (int i = 0; i < elementosPrestables.length; i++) {
            IPrestable elemento = elementosPrestables[i];
            System.out.println("Elemento " + (i+1) + ": " + elemento.toString());
            System.out.println("¿Está prestado? " + elemento.isPrestado());
            
            elemento.prestar();
            System.out.println("Después de prestar: ¿Está prestado? " + elemento.isPrestado());
            
            elemento.devolver();
            System.out.println("Después de devolver: ¿Está prestado? " + elemento.isPrestado());
            System.out.println();
        }
        
        System.out.println("=== FIN DE LAS PRUEBAS ===");
    }
}