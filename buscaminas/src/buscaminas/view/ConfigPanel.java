// Archivo: buscaminas/view/ConfigPanel.java
package buscaminas.view;

import buscaminas.controller.IViewConstants; // Importamos la interfaz
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConfigPanel extends JPanel {

    // Usamos un Map para asociar los identificadores de la interfaz con los campos
    private final Map<String, JTextField> textFields = new HashMap<>();
    private JButton playButton;

    public ConfigPanel() {
        setLayout(new GridLayout(8, 1, 5, 5));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // Creamos los componentes y los guardamos en el Map con su clave
        add(new JLabel("Dimensión X (ancho):"));
        JTextField xField = new JTextField("10");
        textFields.put(IViewConstants.FIELD_DIMENSION_X, xField);
        add(xField);

        add(new JLabel("Dimensión Y (alto):"));
        JTextField yField = new JTextField("10");
        textFields.put(IViewConstants.FIELD_DIMENSION_Y, yField);
        add(yField);

        add(new JLabel("Cantidad de Minas:"));
        JTextField minesField = new JTextField("10");
        textFields.put(IViewConstants.FIELD_MINES_AMOUNT, minesField);
        add(minesField);

        playButton = new JButton("Jugar");
        
        add(new JLabel());
        add(playButton);
    }
    
    /**
     * Método genérico para que el controlador obtenga el texto de cualquier campo.
     * @param fieldIdentifier La clave del campo, definida en IViewConstants.
     * @return El texto del campo solicitado, o null si el identificador es inválido.
     */
    public String getFieldText(String fieldIdentifier) {
        JTextField field = textFields.get(fieldIdentifier);
        return (field != null) ? field.getText() : null;
    }

    /**
     * El controlador llama a este método para añadir su lógica al botón "Jugar".
     * @param listener El ActionListener que definirá la lógica del juego.
     */
    public void addPlayButtonListener(ActionListener listener) {
        this.playButton.addActionListener(listener);
    }
    
    /**
     * Devuelve el botón para que el controlador pueda asignarle un ActionCommand.
     * @return el botón de Jugar.
     */
    public JButton getPlayButton() {
        return playButton;
    }
}