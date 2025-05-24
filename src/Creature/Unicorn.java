/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.Dungeon;
import Class.Sprite;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Unicorn que hereda de la clase Monster.
 * Representa una creatura específica (Unicorn) en el juego.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Unicorn extends Monster{

    /**
     * Ancho del objeto Unicorn.
     */
    public static final int WIDTH = 25;

    /**
     * Alto del objeto Unicorn.
     */
    public static final int HEIGHT = 25;

    /**
     * Constructor de la clase Unicorn.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     * @param x  La coordenada x del Unicorn.
     * @param y  La coordenada y del Unicorn.
     * @param dungeon  El calabozo en el que se encuentra el Unicorn.
     */
    public Unicorn(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 500, 80, 12, 0, new ImageIcon("Unicorn.png"), dungeon);
    }

    /**
     * Obtiene la altura del Unicorn.
     * @return La altura del Unicorn.
     */
    @Override
    public int getHeight() {
        return HEIGHT;
    }

    /**
     * Obtiene el ancho del Unicorn.
     * @return El ancho del Unicorn.
     */
    @Override
    public int getWidth() {
        return WIDTH;
    }

}



