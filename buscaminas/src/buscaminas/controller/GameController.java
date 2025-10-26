package buscaminas.controller;

import buscaminas.model.Grid;
import buscaminas.model.GridBuilder;

// Importaciones de Swing eliminadas (JOptionPane, Color, Component, SwingUtilities)
import javax.swing.JButton; // Necesario solo para el casting del event source
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameController extends MouseAdapter implements ActionListener {

    private Grid model;
    private GridBuilder gridBuilder;
    private final IView view; // Depende de la interfaz, no de la clase Window

    public GameController(IView view, GridBuilder gridBuilder) {
        this.view = view;
        this.gridBuilder = gridBuilder;
        setListeners();
    }

    private void setListeners() {
        // La vista es responsable de poner el ActionCommand en su botón.
        // El controlador solo se registra.
        this.view.addPlayButtonListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Accedemos a la constante estática desde la interfaz
        if (e.getActionCommand().equals(IView.PLAY_BUTTON_COMMAND)) {
            handlePlayAction();
        }
    }

    private void handlePlayAction() {
        try {
            // Obtenemos datos a través de la interfaz
            String xText = view.getConfigFieldText(IView.FIELD_DIMENSION_X);
            String yText = view.getConfigFieldText(IView.FIELD_DIMENSION_Y);
            String minesText = view.getConfigFieldText(IView.FIELD_MINES_AMOUNT);

            int x = Integer.parseInt(xText);
            int y = Integer.parseInt(yText);
            int mines = Integer.parseInt(minesText);

            if (x <= 0 || y <= 0 || mines <= 0 || mines >= x * y) {
                // Delegamos los mensajes a la vista
                view.showErrorMessage("Valores inválidos.");
                return;
            }

            this.model = this.gridBuilder.build(x, y, mines);
            // Comandamos a la vista
            this.view.initializeGrid(x, y, this);
            this.view.packView();
            
        } catch (NumberFormatException ex) {
            // Delegamos los mensajes a la vista
            view.showErrorMessage("Por favor, ingrese solo números.");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // El casting es la única dependencia de Swing (JButton) necesaria
        // para recuperar las coordenadas asociadas al componente.
        JButton button = (JButton) e.getSource();
        int[] coords = (int[]) button.getClientProperty("coords");
        int i = coords[0];
        int j = coords[1];

        // --- CLICK IZQUIERDO ---
        // Reemplazamos SwingUtilities por e.getButton()
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (model.isShown(i, j) || model.isFlagged(i, j)) return;

            try {
                model.showField(i, j);
                if (model.getMinasCercanas(i, j) == 0) {
                    model.showGridNeighbors(i, j);
                }

                // Delegamos la actualización de la vista
                view.updateGrid(model); 

            } catch (Exception ex) {
                // La vista es responsable de revelar las minas y mostrar el mensaje
                view.revealAllMines(model);
                view.showLossMessage("💣 ¡Boom! Has encontrado una mina.");
                view.disableGrid();
            }
        }

        // --- CLICK DERECHO ---
        // Reemplazamos SwingUtilities por e.getButton()
        else if (e.getButton() == MouseEvent.BUTTON3) {
            if (model.isShown(i, j)) {
                return;
            }

            if (model.isFlagged(i, j)) {
                model.unflagField(i, j);
            } else {
                model.flagField(i, j);
            }

            // Delegamos la actualización de la vista
            view.updateGrid(model);

            if (model.isWin()) {
                // La vista es responsable de revelar las minas y mostrar el mensaje
                view.revealAllMines(model);
                view.showWinMessage("🎉 ¡Felicidades! Has ganado.");
                view.disableGrid();
            }
        }
    }
    
    // Los métodos updateGridView(), disableGrid() y revealAllMines()
    // han sido eliminados del controlador.
}