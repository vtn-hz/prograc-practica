package buscaminas.view;

import buscaminas.controller.IView; // 1. Importar la interfaz
import buscaminas.model.Grid;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane; // 2. El único lugar donde se importa JOptionPane

/**
 * Ventana principal del juego.
 * Implementa la interfaz IView y actúa como el punto de entrada central
 * para que el Controlador interactúe con la Vista.
 * Delega tareas específicas a ConfigPanel y GridPanel.
 */
public class Window extends JFrame implements IView {

    private final ConfigPanel configPanel;
    private final GridPanel gridPanel;

    public Window() {
        setTitle("Buscaminas (Arquitectura MVC)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Un poco de espacio

        // Inicializar los componentes de la vista
        configPanel = new ConfigPanel();
        gridPanel = new GridPanel();

        // Añadir componentes al frame
        add(configPanel, BorderLayout.WEST);
        add(gridPanel, BorderLayout.CENTER);

        pack(); // Ajustar tamaño inicial
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
    }

    // --- Implementación de IView (Delegación a ConfigPanel) ---

    @Override
    public void addPlayButtonListener(ActionListener listener) {
        configPanel.addPlayButtonListener(listener);
    }

    @Override
    public String getConfigFieldText(String fieldId) {
        return configPanel.getFieldText(fieldId);
    }

    // --- Implementación de IView (Delegación a GridPanel) ---

    @Override
    public void initializeGrid(int width, int height, MouseListener cellMouseListener) {
        gridPanel.initializeGrid(width, height, cellMouseListener);
    }

    @Override
    public void updateGrid(Grid model) {
        gridPanel.updateGridState(model);
    }

    @Override
    public void disableGrid() {
        gridPanel.disableGridState();
    }

    @Override
    public void revealAllMines(Grid model) {
        gridPanel.revealAllMinesState(model);
    }

    // --- Implementación de IView (Lógica propia de la Ventana) ---

    @Override
    public void packView() {
        this.pack(); // Ajusta el tamaño del JFrame
    }

    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showWinMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "¡Ganaste!", JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void showLossMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "¡Perdiste!", JOptionPane.INFORMATION_MESSAGE);
    }
}