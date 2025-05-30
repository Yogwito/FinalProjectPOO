/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 * Excepción personalizada que se lanza cuando no se ha seleccionado un personaje en la selección de personajes.
 * Utilizada para evitar que el juego inicie sin que el usuario haya elegido un caballero.
 *
 * @author juans
 */
public class NoCharacterSelectedException extends Exception {
    /**
     * Crea una nueva excepción con el mensaje especificado.
     * @param mensaje Mensaje descriptivo del error.
     */
    public NoCharacterSelectedException(String mensaje) {
        super(mensaje);
    }
}
