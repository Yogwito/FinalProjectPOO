/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armas;

import Armas.Weapon;
import Class.Dungeon;
import Knight.Knight;
import dungeons.gui.Drawable;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Fireball que hereda de la clase Weapon e implementa la interfaz Drawable.
 * Representa una bola de fuego que puede ser lanzada en el juego.
 *
 * @author Juan Jose Cardona Daza
 * @author Juan Sebastian Arias
 * @author Juan José Trujillo
 * @version 1.0.2
 */
public class Fireball extends Weapon implements Drawable{
    /**
     * Un booleano que indica si la bola de fuego está en rango o no.
     */
    private boolean inRange;

    /**
     * El rango de la bola de fuego.
     */
    private int range;
    
    private Drawable drawable;
    
    /**
     * La distancia en pixeles que se ha movido la bola de fuego.
     */
    private int distanceTraveled = 0;

    /**
     * Constructor de la clase Fireball.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     * @param x  La coordenada x de la bola de fuego.
     * @param y  La coordenada y de la bola de fuego.
     * @param dungeon  El calabozo en el que se encuentra la bola de fuego.
     * @param path La ruta del archivo de imagen para la bola de fuego.
     */
    public Fireball(int x, int y, Dungeon dungeon, String path) {
        super(x, y, 10, 10, Color.RED, dungeon, path);
        inRange = true;
    }
    

    /**
     * Mueve la bola de fuego en la dirección especificada.
     * Si la bola de fuego se mueve fuera de su rango, se marca como fuera de rango.
     * @param direction La dirección en la que se moverá la bola de fuego.
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
     * Dibuja la bola de fuego en el objeto Graphics proporcionado.
     * @param g El objeto Graphics en el que se dibuja la bola de fuego.
     */
    @Override
    public void draw(Graphics g) {
        try {
            ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource(getPath()));
            g.drawImage(image.getImage(), x, y, null);
        } catch (Exception e) {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }
    /**
     * Redibuja la bola de fuego.
     */
    @Override
    public void redraw() {
        drawable.redraw(); 
    }

    /**
     * Obtiene el rango de la bola de fuego.
     * @return El rango de la bola de fuego.
     */
    public int getRange() {
        return range;
    }

    /**
     * Establece el rango de la bola de fuego.
     * @param range El rango a establecer.
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * Obtiene el objeto Drawable asociado a la bola de fuego.
     * @return El objeto Drawable asociado.
     */
    public Drawable getDrawable() {
        return drawable;
    }

    /**
     * Asocia un objeto Drawable a la bola de fuego.
     * @param drawable El objeto Drawable a asociar.
     */
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    /**
     * Ejecuta el ciclo de movimiento y redibujado de la bola de fuego en un hilo.
     * Mueve la bola de fuego en la dirección actual y la redibuja periódicamente.
     */
    public void run() {
        while (true) {
            move(this.getDirection());
            redraw();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
