/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armas;

import Armas.Weapon;
import Class.Dungeon;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * Clase Acha que representa un hacha en el juego. Hereda de Weapon.
 * Permite dibujar el arma en pantalla.
 *
 * @author Juan José Trujillo
 * @author Juan Sebastian Arias
 * @author Juan José Cardona
 * @version 1.0.2
 */
public class Acha extends Weapon{

    /**
     * Constructor de la clase Acha.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     *
     * @param x        La coordenada x del arma.
     * @param y        La coordenada y del arma.
     * @param width    El ancho del arma.
     * @param height   La altura del arma.
     * @param dungeon  El calabozo en el que se encuentra el arma.
     * @param path     La ruta del archivo de imagen para el arma.
     */
    public Acha(int x, int y, int width, int height, Dungeon dungeon, String path) {
        super(x, y, width, height, Color.BLACK, dungeon, path);
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

