// Archivo: buscaminas/controller/GameController.java
package buscaminas.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import buscaminas.model.Grid;
import buscaminas.model.GridAlgorithm;
import buscaminas.view.Window;

// ... (las otras importaciones no cambian)

public class GameController extends MouseAdapter implements ActionListener, IViewConstants {

    private Grid model;
    private final Window view;

    public GameController(Window view) {
        this.view = view;
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
            // >>> CAMBIO CLAVE AQUÍ <<<
            // Pedimos los datos a la vista usando los identificadores de la interfaz.
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
            this.model.setAlgorithm(new GridAlgorithm());
            this.model.populateGrid();

            this.view.getGridPanel().initializeGrid(x, y, this);
            this.view.pack();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Por favor, ingrese solo números.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // ... El resto de la clase (mousePressed, updateButton, etc.) no necesita cambios ...
    // ... pero podemos usar las nuevas constantes para los íconos.
    
    @Override
    public void mousePressed(MouseEvent e) {
        if (model == null) return;

        // >>> AQUÍ SE OBTIENE EL BOTÓN <<<
        // e.getSource() devuelve el objeto que disparó el evento.
        // Lo convertimos (cast) a JButton porque sabemos que solo los botones de la grilla
        // tienen este listener.
        JButton button = (JButton) e.getSource();

        String[] coords = button.getActionCommand().split(",");
        int i = Integer.parseInt(coords[0]);
        int j = Integer.parseInt(coords[1]);

        if (!button.isEnabled()) {
            return;
        }

        // Clic Izquierdo: Revelar celda
        if (SwingUtilities.isLeftMouseButton(e)) {
            // ...
        }
        // Clic Derecho: Marcar/Desmarcar bandera
        else if (SwingUtilities.isRightMouseButton(e)) {
            if (button.getText().equals(FLAG_ICON)) {
                model.unflagField(i, j);
                button.setText("");
            } else if (button.getText().isEmpty()) {
                model.flagField(i, j);
                button.setText(FLAG_ICON);
            }

            if (model.isWin()) {
                this.revealAllMines();
            }
        }
    }
    
    private void revealAllMines() {
        // Obtenemos todos los componentes del GridPanel y los recorremos uno por uno.
        for (Component component : view.getGridPanel().getComponents()) {

            // >>> AQUÍ SE OBTIENE CADA BOTÓN, EN CADA VUELTA DEL BUCLE <<<
            // Cada 'component' del panel se convierte (cast) a JButton.
            JButton button = (JButton) component;
            
            String[] coords = button.getActionCommand().split(",");
            int i = Integer.parseInt(coords[0]);
            int j = Integer.parseInt(coords[1]);

            if (model.isMina(i, j)) {
                button.setText(MINE_ICON); // Usamos la variable 'button' de esta iteración
            }
        }
    }
}