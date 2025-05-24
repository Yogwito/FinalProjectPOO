/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Class;

/**
 * Esta es una interfaz Boundable que se utiliza para verificar la validez de la posición de un sprite.
 * Proporciona un método para verificar si la posición de un sprite es válida o no.
 *
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public interface Boundable {

    /**
     * Verifica si un sprite es válido o no.
     *
     * @param sprite El sprite que se quiere verificar.
     * @return true si la posición del sprite es válida, false en caso contrario.
     */
    public boolean isValid(Sprite sprite);
}

