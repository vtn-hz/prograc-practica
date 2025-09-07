package tp3_exercise5;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE AUTOMÓVILES ===\n");
        
        // Crear automóvil automático
        Automovil autoAutomatico = new AutomovilAutomatico("ABC123");
        System.out.println("Automóvil Automático creado:");
        System.out.println(autoAutomatico);
        System.out.println();
        
        // Crear automóvil manual
        Automovil autoManual = new AutomovilManual("XYZ789", 180.0);
        System.out.println("Automóvil Manual creado:");
        System.out.println( autoManual);
        System.out.println();
        
        // Pruebas con automóvil automático
        System.out.println("=== PRUEBAS AUTOMÓVIL AUTOMÁTICO ===");
        testAutomatico((AutomovilAutomatico)autoAutomatico);
        
        System.out.println("\n=== PRUEBAS AUTOMÓVIL MANUAL ===");
        testManual((AutomovilManual)autoManual);
        
        System.out.println("\n=== PRUEBAS DE LÍMITES ===");
        testLimites();
    }
    
    private static void testAutomatico(AutomovilAutomatico auto) {
        System.out.println("Estado inicial: " + auto);
        
        // Acelerar gradualmente para probar cambios de marcha automáticos
        System.out.println("\nAcelerando paso a paso:");
        acelerar(auto, 5);   // Debería estar en marcha 2 (Primera)
        acelerar(auto, 10);  // Debería estar en marcha 3 (Segunda)
        acelerar(auto, 20);  // Debería estar en marcha 4 (Tercera)
        acelerar(auto, 25);  // Debería estar en marcha 5 (Cuarta)
        
        System.out.println("\nFrenando gradualmente:");
        frenar(auto, 15);    // Debería cambiar de marcha automáticamente
        frenar(auto, 20);    // Debería seguir cambiando
        frenar(auto, 30);    // Debería llegar a marchas bajas
        
        System.out.println("\nProbando reversa:");
        frenar(auto, 50);    // Debería ir a reversa (marcha 0)
    }
    
    private static void testManual(AutomovilManual auto) {
        System.out.println("Estado inicial: " + auto);
        
        System.out.println("\nAcelerando:");
        acelerar(auto, 20);
        acelerar(auto, 30);
        acelerar(auto, 40);
        
        // Cambiar marchas manualmente
        System.out.println("\nCambiando marchas manualmente:");
        auto.setMarcha(1);
        System.out.println("Marcha cambiada a 1: " + auto);
        
        auto.setMarcha(3);
        System.out.println("Marcha cambiada a 3: " + auto);
        
        System.out.println("\nFrenando:");
        frenar(auto, 25);
        frenar(auto, 30);
        frenar(auto, 50); // No debería ir a velocidades negativas
    }
    
    private static void testLimites() {
        Automovil auto = new AutomovilAutomatico("TEST001", 100.0, -15.0);
        System.out.println("Automóvil para pruebas de límites: " + auto);
        
        System.out.println("\nProbando aceleración más allá del límite:");
        acelerar(auto, 200); // Debería limitarse a velocidadMaxima
        
        System.out.println("\nProbando frenado más allá del límite mínimo:");
        frenar(auto, 200); // Debería limitarse a minVel
        
        System.out.println("\nProbando valores negativos:");
        acelerar(auto, -10); // No debería hacer nada
        frenar(auto, -5);    // No debería hacer nada
    }
    
    private static void acelerar(Automovil auto, double velocidad) {
        auto.acelerar(velocidad);
        System.out.println("Después de acelerar +" + velocidad + ": " + auto);
    }
    
    private static void frenar(Automovil auto, double velocidad) {
        auto.frenar(velocidad);
        System.out.println("Después de frenar -" + velocidad + ": " + auto);
    }
}