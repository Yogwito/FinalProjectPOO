
package Class;

import interfaces.Writer;
import java.io.*;
import java.util.*;

public class RegistroPartida implements Writer {

    private final String archivo = "puntajes.txt";

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
     * Guarda los puntajes actualizados.
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
