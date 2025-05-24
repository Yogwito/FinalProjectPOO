/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import Creature.Unicorn;
import Knight.Archer;
import Knight.Assasin;
import Knight.Barbarian;
import Knight.Magician;
import Knight.SwordMan;
import Knight.Tank;
import dungeons.gui.Downgrade;
import dungeons.gui.Drawable;
import dungeons.gui.Upgrade;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 * Esta es una clase abstracta LivingBeing que hereda de la clase Sprite.
 * Representa un ser vivo en un juego, que puede ser un monstruo o un caballero.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public abstract class LivingBeing extends Sprite{

    /**
     * Un objeto Drawable que representa la apariencia del ser vivo.
     */
    private Drawable drawable;

    /**
     * La salud del ser vivo.
     */
    private int health;

    /**
     * El daño que puede infligir el ser vivo.
     */
    private int damage;

    /**
     * El rango de ataque del ser vivo.
     */
    private int range;

    /**
     * La velocidad del ser vivo.
     */
    private int speed;

    /**
     * La imagen del ser vivo.
     */
    private ImageIcon image;

    /**
     * El calabozo en el que se encuentra el ser vivo.
     */
    private Dungeon dungeon;
    

    /**
     *  Constructor que crea instancias de la clase LivingBeing.
     * @param x posicion en x del Livingbeing
     * @param y posicion en y del Livingbeing
     * @param width ancho del Livingbeing
     * @param height alto del Livingbeing
     * @param health Vida del Livingbeing
     * @param damage Daño que genera el Livingbeing
     * @param range Rango de ataque del Livingbeing
     * @param speed Velocidad de movimiento del Livingbeing
     * @param image Imagen que representa el Livingbeing
     */
   

    public LivingBeing(int x, int y, int width, int height, int health, int damage, int range, int speed ,ImageIcon image, Dungeon dungeon) {
        super(x, y, width, height, Color.BLUE);
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.image = image; 
        
    }
    
    /**
    * Establece el objeto Drawable que representa la apariencia del ser vivo.
    * @param drawable El objeto Drawable a establecer.
    */
   public void setDrawable(Drawable drawable) {
       this.drawable = drawable;
       
   }
    
    /**
    * Establece el calabozo en el que se encuentra el ser vivo.
    * @param dungeon El calabozo a establecer.
    */
   public void setDungeon(Dungeon dungeon) {
       this.dungeon = dungeon;
   }

   /**
    * Quita vida al ser vivo.
    * @param daño La cantidad de vida a quitar.
    */
   public void quitarVida(int daño){
       health = health - daño;
   }

   /**
    * Método para que el ser vivo ataque.
    */
   public void attack(){
       
   }

    
    /**
    * Dibuja la imagen que representa el ser vivo en el objeto Graphics proporcionado.
    * @param g El objeto Graphics en el que se dibuja el ser vivo.
    */
    @Override
    public void draw(Graphics g) {
        if (image != null) {
            g.drawImage(image.getImage(), x, y,null);
        } else {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }
    
    
    
 
    public void redraw() {
        getDrawable().redraw();
    }

    /**
    * Obtiene la salud del ser vivo.
    * @return La salud del ser vivo.
    */
   public int getHealth() {
       return health;
   }

   /**
    * Establece la salud del ser vivo.
    * @param ataque La cantidad de salud a establecer.
    */
   public void setHealth(int ataque) {
       this.health = health - ataque;
   }

   /**
    * Obtiene el daño que puede infligir el ser vivo.
    * @return El daño que puede infligir el ser vivo.
    */
   public int getDamage() {
       return damage;
   }

   /**
    * Establece el daño que puede infligir el ser vivo.
    * @param damage El daño a establecer.
    */
   public void setDamage(int damage) {
       this.damage = damage;
   }

   /**
    * Obtiene el rango de ataque del ser vivo.
    * @return El rango de ataque del ser vivo.
    */
   public int getRange() {
       return range;
   }

   /**
    * Establece el rango de ataque del ser vivo.
    * @param range El rango de ataque a establecer.
    */
   public void setRange(int range) {
       this.range = range;
   }

   /**
    * Obtiene la velocidad del ser vivo.
    * @return La velocidad del ser vivo.
    */
   public int getSpeed() {
       return speed;
   }

   /**
    * Establece la velocidad del ser vivo.
    * @param speed La velocidad a establecer.
    */
   public void setSpeed(int speed) {
       this.speed = speed;
   }

   /**
    * Obtiene el objeto Drawable que representa la apariencia del ser vivo.
    * @return El objeto Drawable que representa la apariencia del ser vivo.
    */
   public Drawable getDrawable() {
       return drawable;
   }

   /**
    * Obtiene la coordenada x del ser vivo.
    * @return La coordenada x del ser vivo.
    */
   @Override
   public int getX() {
       return super.getX(); 
   }

   /**
    * Obtiene la coordenada y del ser vivo.
    * @return La coordenada y del ser vivo.
    */
   @Override
   public int getY() {
       return super.getY(); 
   }
}
