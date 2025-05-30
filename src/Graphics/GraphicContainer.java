/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graphics;

import java.awt.Graphics;
import java.util.List;
import Class.Sprite;

/**
 * Clase GraphicContainer que gestiona y dibuja una lista de sprites en pantalla.
 * Permite establecer la lista de sprites y delega el dibujo de cada uno en su método draw.
 *
 * @author Juan Sebastian Arias
 * @author Juan Jose Trujillo
 * @author Juan Jose Cardona
 * @version 1.0.2
 */
public class GraphicContainer {
    /**
     * Lista de sprites a gestionar y dibujar.
     */
    private List<Sprite> sprites;

    /**
     * Constructor de GraphicContainer.
     * @param sprites Lista de sprites a gestionar.
     */
    public GraphicContainer(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    /**
     * Establece la lista de sprites a gestionar.
     * @param sprites Nueva lista de sprites.
     */
    public void setSprites(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    /**
     * Dibuja todos los sprites gestionados en el contexto gráfico proporcionado.
     * @param g Contexto gráfico donde se dibujan los sprites.
     */
    public void draw(Graphics g) {
        for (Sprite s : sprites) {
            s.draw(g);
        }
    }
}