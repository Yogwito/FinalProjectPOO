/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armas;

import Class.Dungeon;
import Class.LivingBeing;
import Class.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Espada que hereda de la clase Weapon.
 * Representa un arma específica (Espada) en el juego.
 *
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Espada extends Weapon{
    
    /**
     * Constructor de la clase Espada.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     *
     * @param x        La coordenada x del arma.
     * @param y        La coordenada y del arma.
     * @param width    El ancho del arma.
     * @param height   La altura del arma.
     * @param dungeon  El calabozo en el que se encuentra el arma.
     * @param path     La ruta del archivo de imagen para el arma.
     */
    public Espada(int x, int y, int width, int height, Dungeon dungeon, String path) {
        super(x, y, width, height, Color.black, dungeon, path);
    }
    
    /**
     * Comprueba si esta arma colisiona con otro sprite.
     *
     * @param sprite El otro sprite con el que se está comprobando la colisión.
     * @return true si existe colisión, false en caso contrario.
     */
    @Override
    public boolean checkCollision(Sprite sprite) {
        return super.checkCollision(sprite);
    }

    /**
     * Método para redibujar el arma.
     * Este método aún no está implementado.
     */
    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

