// Archivo: buscaminas/controller/IViewConstants.java
package buscaminas.controller;

/**
 * Interfaz para centralizar los identificadores de componentes y comandos.
 * El controlador usa estas constantes para solicitar datos a la vista,
 * sin necesidad de conocer los nombres de las variables internas de la vista.
 */
public interface IViewConstants {
    
    // --- Comandos de Acción ---
    String PLAY_BUTTON_COMMAND = "JUGAR";

    // --- Identificadores para Campos de Datos ---
    String FIELD_DIMENSION_X = "FIELD_X";
    String FIELD_DIMENSION_Y = "FIELD_Y";
    String FIELD_MINES_AMOUNT = "FIELD_MINES";

    // --- Textos y Símbolos de la UI ---
    String FLAG_ICON = "🚩";
    String MINE_ICON = "💣";
}