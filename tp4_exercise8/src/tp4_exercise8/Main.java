package tp4_exercise8;

import tp4_exercise8.model.*;
import tp4_exercise8.view.PersonajesFrame;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Personaje> personajes = new ArrayList<>();
        personajes.add(new Arquero("Legolas", 500, 0, 0));
        personajes.add(new Caballero("Arturo", 500, 3, 4));
        personajes.add(new Guerrero("Conan", 800, 50, 1, 1));

        SwingUtilities.invokeLater(() -> {
            new PersonajesFrame(personajes).setVisible(true);
        });
    }
}
