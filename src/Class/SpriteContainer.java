/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.ArrayList;
import java.util.List;
import Class.Sprite;
import Class.SpriteMobile;

/**
 * Clase SpriteContainer que gestiona una colección de sprites.
 * Permite agregar, eliminar, obtener y actualizar sprites móviles.
 *
 * @author Juan José Cardona Daza
 * @author Juan Sebastian Arias
 * @author Juan José Trujillo
 * @version 1.0.1
 */
public class SpriteContainer {
    /** Lista de sprites gestionados por el contenedor. */
    private List<Sprite> sprites = new ArrayList<>();

    /**
     * Agrega un sprite al contenedor.
     * @param s Sprite a agregar.
     */
    public void agregar(Sprite s) {
        sprites.add(s);
    }

    /**
     * Elimina un sprite del contenedor.
     * @param s Sprite a eliminar.
     */
    public void eliminar(Sprite s) {
        sprites.remove(s);
    }

    /**
     * Obtiene la lista de todos los sprites.
     * @return Lista de sprites.
     */
    public List<Sprite> getTodos() {
        return sprites;
    }

    /**
     * Actualiza la posición de todos los sprites móviles en el contenedor.
     */
    public void actualizar() {
        for (Sprite s : sprites) {
            if (s instanceof SpriteMobile) {
                ((SpriteMobile) s).mover();
            }
        }
    }
}