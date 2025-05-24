
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armas;

import Class.Dungeon;
import Class.LivingBeing;
import Class.Sprite;
import Class.Wall;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Weapon que hereda de la clase Sprite e implementa la interfaz Drawable.
 * Representa un arma que posee un personaje en el juego.
 *
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public abstract class Weapon extends Sprite implements dungeons.gui.Drawable{
    /**
    * Un entero que almacena la dirección de movimiento del arma.
    */
   private int direction;

   /**
    * Un booleano que indica si el arma ha expirado o no.
    */
   private boolean expired;

   /**
    * Una referencia al calabozo (Dungeon) en el que se encuentra el arma.
    */
   private Dungeon dungeon;

   /**
    * Un entero que representa el daño que puede infligir el arma.
    */
   private int damage;

   /**
    * Una referencia al ser vivo (LivingBeing) que dispara el arma.
    */
   private LivingBeing shooter;

   /**
    * Una cadena que representa la ruta del archivo de imagen para el arma.
    */
   private String path;

   /**
    * Un booleano que indica si el arma está en rango  de ataque o no.
    */
   private boolean inRange;


    /**
     * Constructor de la clase Weapon.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     *
     * @param x        La coordenada x del arma.
     * @param y        La coordenada y del arma.
     * @param width    El ancho del arma.
     * @param height   La altura del arma.
     * @param dungeon  El calabozo en el que se encuentra el arma.
     * @param path     La ruta del archivo de imagen para el arma.
     */
    public Weapon(int x, int y, int width, int height, Color color, Dungeon dungeon, String path) {
        super(x, y, width, height, color);
        this.direction = 0;
        this.expired = false;
        this.dungeon = dungeon;
        this.path = path;
        inRange = true;
    }

    /**
     * Constructor vacío de la clase Weapon.
     */
    public Weapon() {
        super(0, 0, 0, 0, null);
    }
    
    /**
     * Establece la dirección de movimiento del arma.
     *
     * @param direction La dirección de movimiento a establecer.
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * Dibuja el arma en el objeto Graphics proporcionado.
     *
     * @param g El objeto Graphics en el que se dibuja el arma.
     */
    @Override
    public void draw(Graphics g) {
        ImageIcon image = new ImageIcon(getPath());
        if (image != null) {
            g.drawImage(image.getImage(), x, y,null);
        } else {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }

    /**
     * Comprueba si el arma colisiona con otro sprite.
     *
     * @param target El sprite con el que se está comprobando la colisión.
     * @return true si hay colisión, false en caso contrario.
     */
    public boolean checkCollision(LivingBeing target) {
        // Check for collisions with walls
        for (Wall wall : dungeon.getMuros()) {
            if (wall.checkCollision(this)) {
                setExpired(true);
                
                break;
            }
        }

        // Check for collisions with living beings
        if (target != null && target.checkCollision(this)) {
            target.setHealth(target.getHealth() - damage);
            setExpired(true);
            return true;
        }
        return false;
    }

    /**
     * Comprueba si el arma ha expirado.
     *
     * @return true si el arma ha expirado, false en caso contrario.
     */
    public boolean isExpired() {
    return expired;
    }

    /**
     * Establece si el arma ha expirado.
     *
     * @param expired El valor a establecer.
     */
    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    /**
     * Establece el ser vivo que dispara el arma.
     *
     * @param shooter El ser vivo a establecer.
     */
    public void setShooter(LivingBeing shooter) {
        this.shooter = shooter;
    }

    /**
     * Obtiene la ruta del archivo de imagen del arma.
     *
     * @return La ruta del archivo de imagen.
     */
    public String getPath() {
        return path;
    }
    
    /**
     * Comprueba si el arma está en rango.
     *
     * @return true si el arma está en rango, false en caso contrario.
     */
    public boolean isInRange() {
        return inRange;
    }

    /**
     * Método para mover el arma.
     * Este método aún no está implementado.
     *
     * @param i El parámetro de movimiento.
     */
    public void move(int i) {
        
    }

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }
    
}

    


