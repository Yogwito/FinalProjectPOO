package Class;

import interfaces.Writer;
import java.io.*;
import java.util.*;

/**
 * Clase RegistroPartida utilizada para guardar y leer los puntajes de los jugadores.
 * Implementa la interfaz Writer para persistencia de datos de puntajes.
 * Permite registrar y actualizar el puntaje más alto de cada jugador en un archivo de texto.
 *
 * @author (autor/es original/es)
 * @version 1.0
 */

public class RegistroPartida implements Writer {

    /**
     * Nombre del archivo donde se guardan los puntajes.
     */
    private final String archivo = "puntajes.txt";

    /**
     * Guarda el puntaje de un jugador solo si es mayor al ya registrado.
     * @param nombreJugador Nombre del jugador.
     * @param nuevoPuntaje Nuevo puntaje a guardar.
     */
    @Override
    public void guardar(String nombreJugador, int nuevoPuntaje) {
        Map<String, Integer> puntajes = cargarPuntajes();

        int puntajeGuardado = puntajes.getOrDefault(nombreJugador, 0);
        if (nuevoPuntaje > puntajeGuardado) {
            puntajes.put(nombreJugador, nuevoPuntaje);
            guardarPuntajes(puntajes);
        }
    }
    /**
     * Guarda el puntaje más alto alcanzado por el jugador.
     * @param nombreJugador Nombre del jugador.
     * @param nuevoPuntaje Nuevo puntaje a registrar.
     */
    public void registrarPuntaje(String nombreJugador, int nuevoPuntaje) {
        Map<String, Integer> puntajes = cargarPuntajes();

        int puntajeGuardado = puntajes.getOrDefault(nombreJugador, 0);
        if (nuevoPuntaje > puntajeGuardado) {
            puntajes.put(nombreJugador, nuevoPuntaje);
            guardarPuntajes(puntajes);
        }
    }

    /**
     * Carga los puntajes desde el archivo.
     * @return Un mapa con los nombres de los jugadores y sus puntajes.
     */
    private Map<String, Integer> cargarPuntajes() {
        Map<String, Integer> puntajes = new HashMap<>();
        File file = new File(archivo);

        if (!file.exists()) return puntajes;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(" - ");
                if (partes.length == 2) {
                    puntajes.put(partes[0], Integer.parseInt(partes[1]));
                }
            }
        } catch (IOException | NumberFormatException ignored) {}

        return puntajes;
    }

    /**
     * Guarda los puntajes actualizados en el archivo.
     * @param puntajes Mapa con los nombres de los jugadores y sus puntajes.
     */
    private void guardarPuntajes(Map<String, Integer> puntajes) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, Integer> entry : puntajes.entrySet()) {
                writer.println(entry.getKey() + " - " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
