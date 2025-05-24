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
 * Esta es una clase Escudo que hereda de la clase Weapon.
 * Representa un arma específica (Escudo) en el juego.
 *
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Escudo extends Weapon{

    /**
     * Constructor de la clase Escudo.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     *
     * @param x        La coordenada x del arma.
     * @param y        La coordenada y del arma.
     * @param width    El ancho del arma.
     * @param height   La altura del arma.
     * @param dungeon  El calabozo en el que se encuentra el arma.
     * @param path     La ruta del archivo de imagen para el arma.
     */
    public Escudo(int x, int y, int width, int height, Dungeon dungeon, String path) {
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

