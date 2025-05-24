
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armas;

import Armas.Weapon;
import Class.Dungeon;
import Class.LivingBeing;
import dungeons.gui.Drawable;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * La clase Arrow representa una flecha en el juego. 
 * Esta clase extiende de la clase Weapon, lo que significa que hereda todas las propiedades y métodos de la clase Weapon.
 * Implementa el método redraw() de la interfaz Drawable.
 * @author Santiago Jiménez
 * @author Daniel Felipe López
 * @version 1.0.2
 */
public class Arrow extends Weapon {
    
    /**
     * Este atributo indica si la flecha está dentro del rango.
     */
    private boolean inRange;

    /**
     * Este atributo representa el rango de la flecha en pixeles.
     */
    private int range;
    
    /**
     * La distancia en pixeles que se ha movido la bola de fuego.
     */
    private int distanceTraveled = 0;
    
    /**
     * Constructor de la clase Arrow.
     * Inicializa los atributos de la clase y establece el rango de la flecha.
     * @param x La coordenada x inicial de la flecha.
     * @param y La coordenada y inicial de la flecha.
     * @param dungeon El calabozo en el que se encuentra la flecha.
     * @param path La ruta al archivo de imagen que representa la flecha.
     */
    public Arrow(int x, int y, Dungeon dungeon, String path) {
        super(x, y, 22, 12, Color.BLACK, dungeon, path);
        inRange = true;
    }
    
    /**
     * Este método se utiliza para mover la flecha en una dirección específica.
     * La flecha se mueve en la dirección especificada y verifica si todavía está dentro del rango.
     * Si la flecha sale del rango, se marca como fuera de rango.
     * @param direction La dirección en la que se debe mover la flecha.
     */
    
    public void move(int direction) {
        switch (direction) {
          case 0 -> {
            // Mover hacia arriba
            y -= 1;
            distanceTraveled += 1; // Actualizar la distancia recorrida
          }
          case 1 -> {
            // Mover hacia abajo
            y += 1;
            distanceTraveled += 1; // Actualizar la distancia recorrida
          }
          case 2 -> {
            // Mover hacia la izquierda
            x -= 1;
            distanceTraveled += 1; // Actualizar la distancia recorrida
          }
          case 3 -> {
            // Mover hacia la derecha
            x += 1;
            distanceTraveled += 1; // Actualizar la distancia recorrida
          }
          default -> {
          }
        }
        // Comprobar si la bola de fuego ha recorrido su rango
        if (distanceTraveled >= range) {
            inRange = false;
        }
    }
        

       
     /**
     * Este método se utiliza para redibujar la flecha.
     */
    @Override
    public void redraw() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Obtiene el valor del atributo 'inRange'.
     * @return El valor actual del atributo 'inRange'.
     */
    public boolean isInRange() {
        return inRange;
    }

    /**
     * Obtiene el valor del atributo 'range'.
     * @return El valor actual del atributo 'range'.
     */
    public int getRange() {
        return range;
    }
    
        
    }

    




