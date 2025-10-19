// Archivo: buscaminas/view/GridPanel.java
package buscaminas.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel que contendrá la grilla de botones del juego.
 * Su contenido se genera dinámicamente basado en la configuración del usuario.
 * Parte de la Vista en el patrón MVC.
 */
public class GridPanel extends JPanel {
    
    public GridPanel() {
        // Inicialmente, el panel puede estar vacío o mostrar un mensaje.
        // Se configurará cuando el juego comience.
    }
    
    /**
     * Método que el controlador llamará para crear la grilla visual del juego.
     * * @param width El número de columnas de la grilla.
     * @param height El número de filas de la grilla.
     * @param cellClickListener El ActionListener para los clics en cada celda (botón).
     */
    public void initializeGrid(int width, int height, ActionListener cellClickListener) {
        // Limpiamos el panel por si había una grilla anterior
        this.removeAll();
        
        // Establecemos un layout de tipo GridLayout con las dimensiones dadas
        this.setLayout(new GridLayout(height, width));
        
        // Creamos y añadimos los botones a la grilla
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                JButton cell = new JButton();
                
                // Le asignamos un "ActionCommand" para poder identificarlo fácilmente
                // en el controlador. Por ejemplo: "fila,columna" -> "3,5"
                cell.setActionCommand(i + "," + j);
                
                // >>> ¡AQUÍ DEBERÍAS SETEAR EL ACTION LISTENER PARA CADA BOTÓN! <<<
                // Este listener será el mismo para todos los botones de la grilla.
                // El controlador lo manejará usando el ActionCommand para saber qué botón se presionó.
                cell.addActionListener(cellClickListener);
                
                this.add(cell);
            }
        }
        
        // Repintamos y revalidamos el panel para que los cambios sean visibles
        this.revalidate();
        this.repaint();
    }
}