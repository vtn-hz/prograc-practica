package tp4_exercise8.view;

import tp4_exercise8.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PersonajesFrame extends JFrame {
    private DefaultListModel<Personaje> personajesModel;
    private JList<Personaje> personajesList;

    public PersonajesFrame(ArrayList<Personaje> personajes) {
        super("Batalla de Personajes");

        // Configuración básica de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Modelo de la lista
        personajesModel = new DefaultListModel<>();
        for (Personaje p : personajes) {
            personajesModel.addElement(p);
        }

        personajesList = new JList<>(personajesModel);
        personajesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scrollPane = new JScrollPane(personajesList);

        JButton atacarButton = new JButton("Atacar");

        atacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atacar();
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(atacarButton);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
    }

    private void atacar() {
        // Necesitamos 2 personajes seleccionados
        if (personajesList.getSelectedIndices().length != 2) {
            JOptionPane.showMessageDialog(this, "Seleccione exactamente 2 personajes: atacante y defensor.");
            return;
        }

        Personaje atacante = personajesList.getSelectedValuesList().get(0);
        Personaje defensor = personajesList.getSelectedValuesList().get(1);

        if (atacante == defensor) {
            JOptionPane.showMessageDialog(this, "Un personaje no puede atacarse a sí mismo.");
            return;
        }

        boolean exito = atacante.ataca(defensor);

        if (exito) {
            if (defensor.getVitalidad() == 0) {
                personajesModel.removeElement(defensor);
                JOptionPane.showMessageDialog(this,
                        defensor.getNombre() + " ha sido asesinado por " + atacante.getNombre());
            } else {
                JOptionPane.showMessageDialog(this,
                        atacante.getNombre() + " atacó a " + defensor.getNombre() +
                                ". Vida restante: " + defensor.getVitalidad());
            }
            personajesList.repaint();
        } else {
            JOptionPane.showMessageDialog(this,
                    atacante.getNombre() + " falló al atacar a " + defensor.getNombre());
        }
    }
}
