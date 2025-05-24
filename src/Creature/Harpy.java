/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.Dungeon;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Harpy que hereda de la clase Monster.
 * Representa un monstruo específico (Harpy) en el juego.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Harpy extends Monster{

    /**
     * Ancho del objeto Harpy.
     */
    public static final int WIDTH = 28;

    /**
     * Alto del objeto Harpy.
     */
    public static final int HEIGHT = 28;

    /**
     * Constructor de la clase Harpy.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     *
     * @param x  La coordenada x del Harpy.
     * @param y  La coordenada y del Harpy.
     * @param dungeon  El calabozo en el que se encuentra el Harpy.
     */
    public Harpy(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 500, 15, 12, 4, new ImageIcon("Harpy.png"), dungeon);
    }

    /**
     * Método para que el Harpy ataque.
     */
    @Override
    public void attack() {
        super.attack();
    }

    /**
     * Obtiene la altura del Harpy.
     * @return La altura del Harpy.
     */
    @Override
    public int getHeight() {
        return HEIGHT;
    }

    /**
     * Obtiene el ancho del Harpy.
     * @return El ancho del Harpy.
     */
    @Override
    public int getWidth() {
        return WIDTH;
    }

}

