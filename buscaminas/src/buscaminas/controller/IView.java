package buscaminas.controller;

import buscaminas.model.Grid;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * Interfaz que define el contrato de la Vista para el Controlador (Patrón MVC).
 * El Controlador interactúa *solo* con esta interfaz, sin conocer Swing.
 * También centraliza las constantes de la aplicación.
 */
public interface IView {

    // --- Constantes (antes en IViewConstants) ---
    String PLAY_BUTTON_COMMAND = "JUGAR";
    String FIELD_DIMENSION_X = "FIELD_X";
    String FIELD_DIMENSION_Y = "FIELD_Y";
    String FIELD_MINES_AMOUNT = "FIELD_MINES";
    String FLAG_ICON = "F";
    String MINE_ICON = "B";

    
    // --- Métodos para Registro de Listeners ---

    /**
     * Registra el listener principal para el botón "Jugar".
     * La vista (p.ej., la Window) es responsable de asignar el PLAY_BUTTON_COMMAND
     * a su componente.
     */
    void addPlayButtonListener(ActionListener listener);

    
    // --- Métodos para Obtener Datos de la Vista ---

    /**
     * Obtiene el texto de un campo de configuración de la vista.
     * @param fieldId Identificador del campo (ej. FIELD_DIMENSION_X).
     * @return El texto contenido en ese campo.
     */
    String getConfigFieldText(String fieldId);


    // --- Métodos para Comandar Cambios en la Vista ---

    /**
     * Le ordena a la vista que cree y muestre la grilla de juego.
     * @param width Columnas de la grilla.
     * @param height Filas de la grilla.
     * @param cellMouseListener El listener (controlador) que atenderá los clics.
     */
    void initializeGrid(int width, int height, MouseListener cellMouseListener);

    /**
     * Le ordena a la vista que sincronice todos sus componentes de la grilla
     * con el estado actual del modelo.
     * @param model El modelo de datos del juego.
     */
    void updateGrid(Grid model);

    /**
     * Le ordena a la vista que deshabilite la interacción con la grilla (post-juego).
     */
    void disableGrid();

    /**
     * Le ordena a la vista que muestre todas las minas (al perder o ganar).
     * @param model El modelo de datos del juego.
     */
    void revealAllMines(Grid model);

    /**
     * Le ordena a la vista que ajuste su tamaño a los componentes internos.
     */
    void packView();

    
    // --- Métodos para Mostrar Mensajes ---

    /**
     * Muestra un mensaje de error genérico.
     * @param message El mensaje a mostrar.
     */
    void showErrorMessage(String message);

    /**
     * Muestra el mensaje de victoria.
     * @param message El mensaje a mostrar.
     */
    void showWinMessage(String message);

    /**
     * Muestra el mensaje de derrota.
     * @param message El mensaje a mostrar.
     */
    void showLossMessage(String message);
}