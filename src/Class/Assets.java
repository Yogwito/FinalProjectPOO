/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * Clase Assets utilizada para cargar y manejar imágenes de números para el score y la cantidad de vida.
 * Carga imágenes de números en un array estático y proporciona un método para obtener la imagen de un número específico.
 *
 * <p>Las imágenes deben estar ubicadas en la carpeta Img dentro del classpath del proyecto.
 * Si alguna imagen no se encuentra, se mostrará un mensaje de advertencia en la consola.</p>
 *
 * @author Juan José Trujillo
 * @author Juan Sebastian Arias
 * @author Juan Jose Cardona Daza
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

