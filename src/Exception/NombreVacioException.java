/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 * Excepción personalizada que se lanza cuando el nombre ingresado está vacío.
 * Utilizada para evitar guardar puntajes sin un nombre válido.
 *
 * @author juans
 */
public class NombreVacioException extends Exception {
    /**
     * Crea una nueva excepción con el mensaje especificado.
     * @param mensaje Mensaje descriptivo del error.
     */
    public NombreVacioException(String mensaje) {
        super(mensaje);
    }
}
