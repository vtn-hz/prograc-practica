package buscaminas.view;

import buscaminas.controller.IView; 
import buscaminas.model.Grid;      

import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Dimension; 
import javax.swing.JButton;
import javax.swing.JPanel;

public class GridPanel extends JPanel {
    
    // --- CONSTANTES DE TAMAÑO ---
    private static final int CELL_SIZE_PX = 40; 
    private static final int FONT_SIZE = 20;    

    // 1. --- UNA ÚNICA FUENTE PARA TODO ---
    // Font.DIALOG es una fuente lógica que Java resuelve en 
    // "Segoe UI Emoji" en Windows, "Apple Color Emoji" en Mac,
    // y "Noto Color Emoji" en Linux. Es la mejor opción.
    private final Font cellFont = new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE);

    // (Eliminamos emojiFont y defaultFont)

    public GridPanel() {
        // Inicialmente vacío
    }
    
    public void initializeGrid(int width, int height, MouseListener cellMouseListener) {
        this.removeAll();
        this.setLayout(new GridLayout(height, width, 1, 1));
        
        Dimension buttonSize = new Dimension(CELL_SIZE_PX, CELL_SIZE_PX);
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                JButton cell = new JButton();
                cell.putClientProperty("coords", new int[]{i, j});
                cell.addMouseListener(cellMouseListener);
                cell.setMargin(new Insets(0, 0, 0, 0));
                cell.setPreferredSize(buttonSize); 
                
                // 2. --- ASIGNAR LA FUENTE UNA SOLA VEZ ---
                cell.setFont(cellFont); 
                
                // (Eliminamos toda la lógica de 'if (this.defaultFont == null)')
                
                this.add(cell);
            }
        }
        
        this.revalidate();
        this.repaint();
    }

    /**
     * Sincroniza TODOS los botones de la vista con el estado actual del modelo.
     */
    public void updateGridState(Grid model) {
        for (Component component : this.getComponents()) {
            JButton button = (JButton) component;
            int[] coords = (int[]) button.getClientProperty("coords");
            int i = coords[0];
            int j = coords[1];

            // 3. --- ELIMINAMOS TODOS LOS button.setFont(...) DE AQUÍ ---

            if (model.isShown(i, j)) {
                
                // --- PARTE 1: CELDA MOSTRADA (NÚMEROS) ---
                button.setOpaque(true);
                button.setBackground(Color.GRAY);
                button.setForeground(Color.BLACK);
                button.setBorderPainted(false);
                button.setEnabled(false); 
                
                int minasCercanas = model.getMinasCercanas(i, j);
                button.setText(minasCercanas > 0 ? String.valueOf(minasCercanas) : "");
                
            } else {
                
                // --- PARTE 2: CELDA NO MOSTRADA (FLAG O VACÍO) ---
                button.setEnabled(true);
                button.setBackground(null); 

                if (model.isFlagged(i, j)) {
                    button.setText(IView.FLAG_ICON); // Ya sea "F" o "🚩", la fuente DIALOG lo manejará
                } else {
                    button.setText("");
                }
            }
        }
    }

    /**
     * Deshabilita todos los botones de la grilla.
     */
    public void disableGridState() {
        for (Component component : this.getComponents()) {
            component.setEnabled(false);
        }
    }

    /**
     * Revela la posición de todas las minas.
     */
    public void revealAllMinesState(Grid model) {
        for (Component component : this.getComponents()) {
            JButton button = (JButton) component;
            
            // 4. --- ELIMINAMOS EL button.setFont(...) DE AQUÍ ---
            
            int[] coords = (int[]) button.getClientProperty("coords");
            int i = coords[0];
            int j = coords[1];
            if (model.isMina(i, j)) {
                button.setText(IView.MINE_ICON); // La fuente DIALOG también manejará la 💣
            }
        }
    }
}