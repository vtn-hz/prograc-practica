package buscaminas;

import buscaminas.controller.GameController;
import buscaminas.model.GridBuilder;
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
            new GameController(new Window(), new GridBuilder());
        });
    }
}