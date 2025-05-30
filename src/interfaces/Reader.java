/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.ArrayList;

/**
 * Interfaz Reader para la lectura de archivos.
 * Define el método para leer el contenido de un archivo y devolverlo como una lista de cadenas.
 *
 * @author juans
 */
public interface Reader {
    /**
     * Lee el contenido de un archivo y lo devuelve como una lista de cadenas.
     * @param filePath Ruta del archivo a leer.
     * @return Lista de líneas leídas del archivo.
     */
    ArrayList<String> read(String filePath);
}
