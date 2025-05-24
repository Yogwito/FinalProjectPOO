/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.Dungeon;
import Class.Sprite;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Basilisk que hereda de la clase Monster.
 * Representa un monstruo específico (Basilisk) en el juego.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Basilisk extends Monster{

    /**
     * Ancho del objeto Basilisk.
     */
    public static final int WIDTH = 30;

    /**
     * Alto del objeto Basilisk.
     */
    public static final int HEIGHT = 27;

    /**
     * Constructor de la clase Basilisk.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     *
     * @param x  La coordenada x del Basilisk.
     * @param y  La coordenada y del Basilisk.
     * @param dungeon  El calabozo en el que se encuentra el Basilisk.
     */
    public Basilisk(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 400, 5, 10, 2, new ImageIcon("Basilisk.png"), dungeon);
    }

    /**
     * Método para que el Basilisk ataque.
     */
    @Override
    public void attack() {
        super.attack();
    }

    /**
     * Obtiene la altura del Basilisk.
     * @return La altura del Basilisk.
     */
    @Override
    public int getHeight() {
        return HEIGHT;
    }

    /**
     * Obtiene el ancho del Basilisk.
     * @return El ancho del Basilisk.
     */
    @Override
    public int getWidth() {
        return WIDTH;
    }

}

