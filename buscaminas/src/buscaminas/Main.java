package buscaminas;

import buscaminas.controller.GameController;
import buscaminas.view.Window;
import javax.swing.SwingUtilities;

/**
 * Clase principal que inicia la aplicación Buscaminas.
 */
public class Main {
    public static void main(String[] args) {
        // SwingUtilities.invokeLater asegura que la GUI se cree y se manipule
        // en el hilo de despacho de eventos (Event Dispatch Thread), lo cual es una
        // práctica recomendada para evitar problemas de concurrencia.
        SwingUtilities.invokeLater(() -> {
            
            // 1. Se crea la Vista.
            // Esto construye la ventana principal y todos sus componentes visuales.
            Window view = new Window();
            
            // 2. Se crea el Controlador y se le pasa la Vista.
            // El constructor del GameController se encarga de "conectar" los listeners
            // de la Vista para que el controlador pueda reaccionar a las acciones del usuario.
            new GameController(view);
            
            // La ventana se hace visible dentro de su propio constructor.
        });
    }
}