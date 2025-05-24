/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * Esta es una clase Assets que se utiliza para cargar y manejar imágenes de números para un score y cantidad de vida.
 * Carga imágenes de números en un array estático y proporciona un método para obtener la imagen de un número específico.
 *
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Assets {
    /**
     * Un array de Image que almacena las imágenes de los números.
     */
    private static Image[] numberImages;

    static {
        // Cargar las imágenes en el array numberImages
        numberImages = new Image[10];
        for (int i = 0; i <= 9; i++) {
            String imagePath = "" + i + ".png";
            numberImages[i] = new ImageIcon(imagePath).getImage();
        }
    }

    /**
     * Devuelve la imagen de un número específico.
     *
     * @param digit El número del que se quiere obtener la imagen.
     * @return La imagen del número si el dígito está en el rango de 0 a 9, null en caso contrario.
     */
    public static Image numbers(int digit) {
        if (digit >= 0 && digit <= 9) {
            return numberImages[digit];
        } else {
            // Manejar el caso en el que el dígito no está en el rango esperado
            // Puedes devolver una imagen predeterminada o lanzar una excepción, según tus necesidades
            return null;
        }
    }
}

