package buscaminas.controller;

import buscaminas.model.Grid;
import buscaminas.model.GridBuilder;
import buscaminas.view.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameController extends MouseAdapter implements ActionListener, IViewConstants {

    private Grid model;
    private GridBuilder gridBuilder;
    private final Window view;

    public GameController(Window view, GridBuilder gridBuilder) {
        this.view = view;
        this.gridBuilder = gridBuilder;
        setListeners();
    }

    private void setListeners() {
        this.view.getConfigPanel().getPlayButton().setActionCommand(PLAY_BUTTON_COMMAND);
        this.view.getConfigPanel().addPlayButtonListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(PLAY_BUTTON_COMMAND)) {
            handlePlayAction();
        }
    }

    private void handlePlayAction() {
        try {
            String xText = view.getConfigPanel().getFieldText(FIELD_DIMENSION_X);
            String yText = view.getConfigPanel().getFieldText(FIELD_DIMENSION_Y);
            String minesText = view.getConfigPanel().getFieldText(FIELD_MINES_AMOUNT);

            int x = Integer.parseInt(xText);
            int y = Integer.parseInt(yText);
            int mines = Integer.parseInt(minesText);

            if (x <= 0 || y <= 0 || mines <= 0 || mines >= x * y) {
                JOptionPane.showMessageDialog(view, "Valores inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.model = this.gridBuilder.build(x, y, mines);
            this.view.getGridPanel().initializeGrid(x, y, this);
            this.view.pack();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Por favor, ingrese solo números.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        int[] coords = (int[]) button.getClientProperty("coords");
        int i = coords[0];
        int j = coords[1];

        // --- CLICK IZQUIERDO ---
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (model.isShown(i, j) || model.isFlagged(i, j)) return;

            try {
                // 1. Revelar la casilla en el modelo
                model.showField(i, j);

                // 2. SI ES CERO, LLAMAR AL BFS (showGridNeighbors)
                if (model.getMinasCercanas(i, j) == 0) {
                    model.showGridNeighbors(i, j); // Llamada al BFS en el modelo
                }

                // 3. Actualizar TODA la grilla
                updateGridView(); 

            } catch (Exception ex) {
                // Era una mina
                button.setText(MINE_ICON);
                revealAllMines();
                JOptionPane.showMessageDialog(view, "💣 ¡Boom! Has encontrado una mina.", "¡Perdiste!", JOptionPane.INFORMATION_MESSAGE);
                disableGrid();
            }
        }

        // --- CLICK DERECHO ---
        else if (SwingUtilities.isRightMouseButton(e)) {
            System.out.println("sone ma sdada");
            // 1. No hacer nada si la celda ya está mostrada
            if (model.isShown(i, j)) {
                return;
            }

            // 2. Actualizar solo el modelo
            // (Asumo que tu modelo tiene 'isFlagged')
            if (model.isFlagged(i, j)) {
                model.unflagField(i, j);
            } else {
                model.flagField(i, j);
                
            }

            // 3. Llamar a la actualización de la vista
            updateGridView();

            // 4. Chequear victoria
            if (model.isWin()) {
                revealAllMines();
                JOptionPane.showMessageDialog(view, "🎉 ¡Felicidades! Has ganado.", "¡Ganaste!", JOptionPane.PLAIN_MESSAGE);
                disableGrid();
            }
        }
    }
    
    /**
     * Sincroniza TODOS los botones de la vista con el estado actual del modelo.
     */
    private void updateGridView() {
        // Itera sobre todos los componentes (JButtons) en el GridPanel
        for (Component component : view.getGridPanel().getComponents()) {
            JButton button = (JButton) component;
            int[] coords = (int[]) button.getClientProperty("coords");
            int i = coords[0];
            int j = coords[1];

            // (Asumo que tu 'model' tiene un método 'isShown(i, j)')
            if (model.isShown(i, j)) {
                
                // --- PARTE 1: CELDA MOSTRADA ---
                button.setOpaque(true);
                button.setBackground(Color.GRAY);
                button.setForeground(Color.BLACK);
                button.setBorderPainted(false);
                button.setMargin(new java.awt.Insets(0, 0, 0, 0));
                
                button.setEnabled(false); // Deshabilitar

                int minasCercanas = model.getMinasCercanas(i, j);
                button.setText(minasCercanas > 0 ? String.valueOf(minasCercanas) : "");
                
            } else {
                
                // --- PARTE 2: CELDA NO MOSTRADA ---
                
                button.setEnabled(true);
                button.setBackground(null); // Usar color por defecto

                // Dibujar la bandera si el modelo dice que está marcada
                // (Asumo que tu 'model' tiene 'isFlagged')
                if (model.isFlagged(i, j)) {
                    button.setText(FLAG_ICON); // 🚩
                } else {
                    button.setText(""); // Sin bandera
                }
            }
        }
    }

    private void disableGrid() {
        for (Component component : view.getGridPanel().getComponents()) {
            component.setEnabled(false);
        }
    }

    private void revealAllMines() {
        for (Component component : view.getGridPanel().getComponents()) {
            JButton button = (JButton) component;
            int[] coords = (int[]) button.getClientProperty("coords");
            int i = coords[0];
            int j = coords[1];
            if (model.isMina(i, j)) {
                button.setText(MINE_ICON);
            }
        }
    }
}