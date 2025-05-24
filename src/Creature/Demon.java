/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.Dungeon;
import Class.Sprite;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Demon que hereda de la clase Monster.
 * Representa un monstruo específico (Demon) en el juego.
 *
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Demon extends Monster{

    /**
     * Ancho del objeto Demon.
     */
    public static final int WIDTH = 30;

    /**
     * Alto del objeto Demon.
     */
    public static final int HEIGHT = 27;

    /**
     * Constructor de la clase Demon.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     * @param x  La coordenada x del Demon.
     * @param y  La coordenada y del Demon.
     * @param dungeon  El calabozo en el que se encuentra el Demon.
     */
    public Demon(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 500, 10, 10, 3, new ImageIcon("Demon.png"), dungeon);
    }

    /**
     * Método para que el Demon ataque.
     */
    @Override
    public void attack() {
        super.attack();
    }

    /**
     * Obtiene la altura del Demon.
     * @return La altura del Demon.
     */
    @Override
    public int getHeight() {
        return HEIGHT;
    }

    /**
     * Obtiene el ancho del Demon.
     * @return El ancho del Demon.
     */
    @Override
    public int getWidth() {
        return WIDTH;
    }

}

