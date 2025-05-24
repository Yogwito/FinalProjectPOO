/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.Dungeon;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Giant que hereda de la clase Monster.
 * Representa un monstruo específico (Giant) en el juego.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Giant extends Monster{

    /**
     * Ancho del objeto Giant.
     */
    public static final int WIDTH = 25;

    /**
     * Alto del objeto Giant.
     */
    public static final int HEIGHT = 31;

    /**
     * Constructor de la clase Giant.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     * @param x La coordenada x del Giant.
     * @param y La coordenada y del Giant.
     * @param dungeon El calabozo en el que se encuentra el Giant.
     */
    public Giant(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 1000, 20, 10, 1, new ImageIcon("Giant.png"), dungeon);
    }

    /**
     * Método para que el Giant ataque.
     */
    @Override
    public void attack() {
        super.attack();
    }

    /**
     * Obtiene la altura del Giant.
     * @return La altura del Giant.
     */
    @Override
    public int getHeight() {
        return HEIGHT;
    }

    /**
     * Obtiene el ancho del Giant.
     * @return El ancho del Giant.
     */
    @Override
    public int getWidth() {
        return WIDTH;
    }

}

