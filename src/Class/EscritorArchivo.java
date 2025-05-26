/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author juans
 * @author trujirendj
 * @author jjdaza
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase EscritorArchivo que permite guardar información en archivos de texto.
 * Se puede usar para registrar resultados, logs o configuraciones del juego.
 * 
 * @author TuNombre
 * @version 1.0
 */
public class EscritorArchivo {

    /**
     * Ruta del archivo de salida.
     */
    private final String ruta;

    /**
     * Constructor de la clase EscritorArchivo.
     * @param ruta Ruta del archivo donde se escribirá.
     */
    public EscritorArchivo(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Escribe una línea en el archivo, sobrescribiendo todo el contenido anterior.
     * @param contenido Línea de texto a escribir.
     */
    public void escribirLinea(String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            writer.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Agrega una nueva línea al final del archivo, sin borrar lo existente.
     * @param contenido Línea de texto a agregar.
     */
    public void agregarLinea(String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, true))) {
            writer.newLine();
            writer.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
