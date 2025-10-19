package buscaminas.controller;

import buscaminas.model.Grid;
import buscaminas.model.GridAlgorithm; // Usamos tu clase
import buscaminas.view.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameController extends MouseAdapter implements ActionListener, IViewConstants {

    private Grid model;
    private final Window view;

    /**
     * Constructor que recibe el modelo y la vista para conectarlos.
     */
    public GameController(Window view) {
        this.view = view;
        setListeners();
        updateViewWithInitialModel();
    }

    private void setListeners() {
        this.view.getConfigPanel().getPlayButton().setActionCommand(PLAY_BUTTON_COMMAND);
        this.view.getConfigPanel().addPlayButtonListener(this);
    }

    /**
     * Dibuja la grilla en la vista basándose en el estado del modelo inicial.
     */
    private void updateViewWithInitialModel() {
        if (model == null || model.getGridFields() == null) return;
        int width = model.getGridFields().length;
        int height = model.getGridFields()[0].length;
        
        view.getGridPanel().initializeGrid(width, height, this);
        view.pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(PLAY_BUTTON_COMMAND)) {
            handlePlayAction();
        }
    }

    /**
     * Lógica para crear una nueva partida al pulsar "Jugar".
     */
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

            this.model = new Grid(x, y, mines);
            // Usamos tu clase GridAlgorithm directamente
            this.model.setAlgorithm(new GridAlgorithm());
            this.model.populateGrid();

            this.view.getGridPanel().initializeGrid(x, y, this);
            this.view.pack();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Por favor, ingrese solo números.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        if (model == null) return;

        JButton button = (JButton) e.getSource();
        if (!button.isEnabled()) return; // No hacer nada si el botón ya fue revelado

        String[] coords = button.getActionCommand().split(",");
        int i = Integer.parseInt(coords[0]);
        int j = Integer.parseInt(coords[1]);

        // --- LÓGICA DE CLIC IZQUIERDO COMPLETA ---
        if (SwingUtilities.isLeftMouseButton(e) && button.getText().isEmpty()) {
            try {
                // El modelo intenta mostrar la celda. Si es una mina, lanzará una excepción.
                model.showField(i, j);
                updateButton(button, i, j); // Actualiza la vista si no es una mina
            } catch (Exception ex) {
                // ¡PERDISTE! La excepción significa que era una mina.
                revealAllMines();
                JOptionPane.showMessageDialog(view, "¡Boom! Has encontrado una mina.", "¡Perdiste!", JOptionPane.INFORMATION_MESSAGE);
                disableGrid();
            }
        }
        // --- LÓGICA DE CLIC DERECHO COMPLETA ---
        else if (SwingUtilities.isRightMouseButton(e)) {
            // Si ya tiene una bandera, se la quita
            if (button.getText().equals(FLAG_ICON)) {
                model.unflagField(i, j);
                button.setText("");
            } 
            // Si está vacía, le pone una bandera
            else if (button.getText().isEmpty()) {
                model.flagField(i, j);
                button.setText(FLAG_ICON);
            }

            // Después de marcar/desmarcar, comprueba si ganaste
            if (model.isWin()) {
                // ¡GANASTE!
                revealAllMines();
                JOptionPane.showMessageDialog(view, "¡Felicidades! Has encontrado todas las minas.", "¡Ganaste!", JOptionPane.PLAIN_MESSAGE);
                disableGrid();
            }
        }
    }
    
    /**
     * Actualiza la apariencia de un botón después de ser revelado.
     */
    private void updateButton(JButton button, int i, int j) {
        button.setEnabled(false); // Deshabilita el botón
        int minasCercanas = model.getMinasCercanas(i, j);
        if (minasCercanas > 0) {
            button.setText(String.valueOf(minasCercanas));
        }
    }
    
    /**
     * Deshabilita toda la grilla al final del juego.
     */
    private void disableGrid() {
        for (Component component : view.getGridPanel().getComponents()) {
            component.setEnabled(false);
        }
    }

    /**
     * Muestra la ubicación de todas las minas al final del juego.
     */
    private void revealAllMines() {
        for (Component component : view.getGridPanel().getComponents()) {
            JButton button = (JButton) component;
            String[] coords = button.getActionCommand().split(",");
            int i = Integer.parseInt(coords[0]);
            int j = Integer.parseInt(coords[1]);
            if (model.isMina(i, j)) {
                // Si la celda es una mina, la muestra
                button.setText(MINE_ICON);
            }
        }
    }
}