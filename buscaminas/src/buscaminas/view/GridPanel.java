package buscaminas.view;

import java.awt.GridLayout;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel que contendrá la grilla de botones del juego.
 * Su contenido se genera dinámicamente basado en la configuración del usuario.
 * Parte de la Vista en el patrón MVC.
 */
public class GridPanel extends JPanel {
    
    public GridPanel() {
        // Inicialmente vacío, se configura al iniciar el juego
    }
    
    /**
     * Crea la grilla de botones del juego.
     * @param width  Número de columnas.
     * @param height Número de filas.
     * @param cellMouseListener Listener de ratón para cada celda.
     */
    public void initializeGrid(int width, int height, MouseListener cellMouseListener) {
        this.removeAll();
        this.setLayout(new GridLayout(height, width));
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                JButton cell = new JButton();
                cell.putClientProperty("coords", new int[]{i, j}); // Guardamos las coordenadas
                cell.addMouseListener(cellMouseListener); // Registramos el mismo listener
                this.add(cell);
            }
        }
        
        this.revalidate();
        this.repaint();
    }
}
