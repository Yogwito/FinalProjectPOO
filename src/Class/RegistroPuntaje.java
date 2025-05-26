
package Class;

import java.io.*;

public class RegistroPuntaje {

    private static final String ARCHIVO = "puntaje_maximo.txt";

    /**
     * Guarda el puntaje solo si es mayor al ya registrado.
     */
    public void guardarPuntajeSiEsMayor(int nuevoPuntaje) {
        int puntajeActual = leerPuntajeActual();

        if (nuevoPuntaje > puntajeActual) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
                writer.write(String.valueOf(nuevoPuntaje));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Lee el puntaje guardado en el archivo.
     * @return puntaje más alto registrado, o 0 si no existe.
     */
    public int leerPuntajeActual() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            return 0;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea = reader.readLine();
            return Integer.parseInt(linea);
        } catch (IOException | NumberFormatException e) {
            return 0;
        }
    }
}
