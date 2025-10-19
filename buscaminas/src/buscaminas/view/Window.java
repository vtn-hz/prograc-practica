// Archivo: buscaminas/view/Window.java
package buscaminas.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * La ventana principal del juego Buscaminas.
 * Contiene el panel de configuración y el panel de la grilla del juego.
 * Siguiendo el patrón MVC, esta clase es parte de la Vista.
 */
public class Window extends JFrame {

    private ConfigPanel configPanel;
    private GridPanel gridPanel;

    public Window() {
        // --- CONFIGURACIÓN BÁSICA DE LA VENTANA ---
        setTitle("Buscaminas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- INICIALIZACIÓN DE PANELES ---
        configPanel = new ConfigPanel();
        gridPanel = new GridPanel();

        // --- AÑADIR PANELES A LA VENTANA ---
        // El panel de configuración irá a la izquierda (OESTE)
        add(configPanel, BorderLayout.WEST);
        
        // La grilla del juego ocupará el espacio central
        add(gridPanel, BorderLayout.CENTER);

        // --- AJUSTE Y VISIBILIDAD ---
        pack(); // Ajusta el tamaño de la ventana al de sus componentes
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true);
    }

    // --- MÉTODOS PARA EL CONTROLADOR ---
    // El controlador necesitará acceso a los paneles para poder
    // configurar los listeners y actualizar la vista.

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public GridPanel getGridPanel() {
        return gridPanel;
    }
}