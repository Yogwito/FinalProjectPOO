package Class;

import java.awt.Color;

/**
 * Clase abstracta SpriteMobile que representa un sprite móvil en el juego.
 * Hereda de Sprite y añade funcionalidad para movimiento mediante velocidad.
 * 
 * @author Juan José Cardona Daza
 * @author Juan Sebastian Arias
 * @author Juan José Trujillo
 * @version 1.0.1
 */
public abstract class SpriteMobile extends Sprite {
    /** Velocidad en el eje X del sprite. */
    protected int velocidadX = 0;
    /** Velocidad en el eje Y del sprite. */
    protected int velocidadY = 0;

    /**
     * Constructor de SpriteMobile.
     * @param x Posición inicial en X.
     * @param y Posición inicial en Y.
     * @param height Altura del sprite.
     * @param color Color del sprite.
     * @param width Ancho del sprite.
     */
    public SpriteMobile(int x, int y,int height, Color color, int width) {
        super(x, y,height,width,color);
    }

    /**
     * Mueve el sprite sumando la velocidad a la posición actual.
     */
    public void mover() {
        this.x += velocidadX;
        this.y += velocidadY;
    }

    /**
     * Establece la velocidad del sprite en los ejes X e Y.
     * @param vx Velocidad en X.
     * @param vy Velocidad en Y.
     */
    public void setVelocidad(int vx, int vy) {
        this.velocidadX = vx;
        this.velocidadY = vy;
    }
}