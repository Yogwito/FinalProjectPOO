/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Wall que hereda de la clase Sprite.
 * Representa un muro que se utiliza para demarcar el mapa del juego.
 * @author Santiago Jiménez
 * @author Daniel Felipe López
 * @version 1.0.2
 */
public class Wall extends Sprite{

    /**
     * Ancho del muro.
     */
    public static final int WIDTH = 35;

    /**
     * Altura del muro.
     */
    public static final int HEIGHT = 40;
    
    /**
     * Imagen estandar de un muro.
     */
    private ImageIcon wall = new ImageIcon("Wall.png");

    /**
     * Constructor de la clase Wall.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     * @param x La coordenada x del muro.
     * @param y La coordenada y del muro.
     */
    public Wall(int x, int y) {
        super(x, y, WIDTH, HEIGHT, Color.GRAY);
    }
    
    /**
     * Dibuja el muro en el objeto Graphics proporcionado.
     * @param g El objeto Graphics en el que se dibuja el muro.
     */
    @Override
    public void draw(Graphics g) {
        wall.paintIcon(null, g, x, y);
    }

    /**
     * Obtiene el ancho del muro.
     * @return El ancho del muro.
     */
    public int getWIDTH() {
        return WIDTH;
    }

    /**
     * Obtiene la altura del muro.
     * @return La altura del muro.
     */
    public int getHEIGHT() {
        return HEIGHT;
    }
}

