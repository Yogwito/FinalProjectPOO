/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Esta es una clase Sprite que representa un objeto gráfico que puede ser dibujado en la pantalla.
 * Contiene propiedades como coordenadas (x, y), dimensiones (ancho, alto) y color.
 * También proporciona métodos para la detección de colisiones y el dibujo del sprite.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public abstract class Sprite {

    /**
     *posicion en x del sprite
     */
    protected int x;

    /**
     * posicion en y del sprite
     */
    protected int y;

    /**
     * Ancho del sprite
     */
    protected int width;

    /**
     * Altura del sprite
     */
    protected int height;

    /**
     * Color del sprite
     */
    protected Color color;

    /**
     * Constructor de la clase Sprite.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     *
     * @param x      La coordenada x del sprite.
     * @param y      La coordenada y del sprite.
     * @param width  El ancho del sprite.
     * @param height La altura del sprite.
     * @param color  El color del sprite.
     */
    public Sprite(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
    /**
     * Comprueba si este sprite colisiona con otro sprite.
     *
     * @param sprite El otro sprite con el que se está comprobando la colisión.
     * @return true si hay colisión, false en caso contrario.
     */
    public boolean checkCollision (Sprite sprite) {
        if(this.getX() < (sprite.getX()) + sprite.getWidth() &&
           this.getX() + this.getWidth() > (sprite.getX()) &&
           this.getY() < (sprite.getY()) + sprite.getHeight() &&
           this.getY() + this.getHeight() > (sprite.getY()))
            return true;
        return false;
    }
    
    /**
     * Método abstracto para dibujar el sprite.
     * Las clases que heredan de Sprite deben implementar este método.
     *
     * @param g El objeto Graphics en el que se dibuja el sprite.
     */
    public abstract void draw(Graphics g);

    // Los siguientes son métodos getter y setter para las propiedades de la clase.

    /**
     *
     * @return
     */

    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
