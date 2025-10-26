package buscaminas.view;

import buscaminas.controller.IView; // 1. Importar la nueva interfaz
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
        textFields.put(IView.FIELD_DIMENSION_X, xField); // 2. Usar IView
        add(xField);

        add(new JLabel("Dimensión Y (alto):"));
        JTextField yField = new JTextField("10");
        textFields.put(IView.FIELD_DIMENSION_Y, yField); // 2. Usar IView
        add(yField);

        add(new JLabel("Cantidad de Minas:"));
        JTextField minesField = new JTextField("10");
        textFields.put(IView.FIELD_MINES_AMOUNT, minesField); // 2. Usar IView
        add(minesField);

        playButton = new JButton("Jugar");
        // 3. La vista (este panel) es ahora responsable de setear el ActionCommand
        playButton.setActionCommand(IView.PLAY_BUTTON_COMMAND); 
        
        add(new JLabel());
        add(playButton);
    }
    
    /**
     * Método genérico para que el controlador obtenga el texto de cualquier campo.
     * @param fieldIdentifier La clave del campo, definida en IView. // 5. Javadoc actualizado
     * @return El texto del campo solicitado, o null si el identificador es inválido.
     */
    public String getFieldText(String fieldIdentifier) {
        JTextField field = textFields.get(fieldIdentifier);
        return (field != null) ? field.getText() : null;
    }

    /**
     * El controlador llama a este método (a través de la Window) 
     * para añadir su lógica al botón "Jugar".
     * @param listener El ActionListener que definirá la lógica del juego.
     */
    public void addPlayButtonListener(ActionListener listener) {
        this.playButton.addActionListener(listener);
    }
    
    // 4. El método getPlayButton() se elimina. 
    // Ya no es necesario y fomenta un mejor encapsulamiento.
}