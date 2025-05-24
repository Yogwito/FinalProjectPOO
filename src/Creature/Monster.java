/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.Boundable;
import Class.Dungeon;
import Armas.Espada;
import Class.LivingBeing;
import Class.Wall;
import Knight.Knight;
import dungeons.gui.Drawable;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
* Clase Monster.
* @author Santiago Jiménez
* @author Daniel Felipe López
* @version 1.0.2
*/
 
public class Monster extends LivingBeing{
    
    private int health;
    private int damage;
    private int range;
    private int speed;
    private ImageIcon image;
    private Dungeon dungeon;
    private boolean yUpMove;
    private boolean yDoMove;
    private boolean xRiMove;
    private boolean xLeMove;
    private int turnCounter;
    
    /**
     * Constructor de la clase Monster.
     *
     * @param x Posición X del monstruo.
     * @param y Posición Y del monstruo.
     * @param width Ancho del monstruo.
     * @param height Altura del monstruo.
     * @param health Vida inicial del monstruo.
     * @param damage Daño que hace el monstruo al atacar.
     * @param range Rango de ataque del monstruo.
     * @param speed Velocidad del monstruo.
     * @param image Imagen del monstruo.
     * @param dungeon Mapa de la clase Dungeon del juego.
     */
    public Monster(int x, int y, int width, int height, int health, int damage, int range, int speed ,ImageIcon image, Dungeon dungeon) {
        super(x, y, width, height, health, damage, range, speed, image, dungeon);
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.image = image; 
        this.dungeon = dungeon;
        yUpMove = false;
        yDoMove = false;
        xRiMove = false;
        xLeMove = false;
        turnCounter = 0;
    }
    
    /**
     * Método que mueve la criatura por el dungeon.
     *
     * @param dungeon Mapa de la clase Dungeon del juego.
     * @param muros Lista de muros del dungeon.
     * @param creatures Lista de criaturas del dungeon.
     * @param arthur Instancia de la clase Knight (el jugador).
     */
    public void moveCreature(Dungeon dungeon, ArrayList<Wall> muros, ArrayList<Monster> creatures, Knight arthur) {
        int xOriginal = x;
        int yOriginal = y;

        // Cambiar de dirección después de 10 vueltas del hilo
        if (turnCounter % 100 == 0) {
            changeDirection();
        }

        if (xLeMove) {
            x -= speed;
            if (verificarMove(muros, creatures, arthur) == -1) {
                x = xOriginal;
                changeDirection();
            } else if (verificarMove(muros, creatures, arthur) == 0){
                x = xOriginal;
                changeDirection();
                dungeon.getArthur().quitarVida(getDamage());
            }
        } else if (yUpMove) {
            y -= speed;
            if (verificarMove(muros, creatures, arthur) == -1) {
                y = yOriginal;
                changeDirection();
            } else if (verificarMove(muros, creatures, arthur) == 0){
                y = yOriginal;
                changeDirection();
                dungeon.getArthur().quitarVida(getDamage());
            }
        } else if (xRiMove) {
            x += speed;
            if (verificarMove(muros, creatures, arthur) == -1) {
                x = xOriginal;
                changeDirection();
            } else if (verificarMove(muros, creatures, arthur) == 0){
                x = xOriginal;
                changeDirection();
                dungeon.getArthur().quitarVida(getDamage());
            }
        } else if (yDoMove) {
            y += speed;
            if (verificarMove(muros, creatures, arthur) == -1) {
                y = yOriginal;
                changeDirection();
            } else if (verificarMove(muros, creatures, arthur) == 0){
                y = yOriginal;
                changeDirection();
                dungeon.getArthur().quitarVida(getDamage());
            }
        }

        turnCounter++;
    }
    
     /**
     * Verifica el movimiento del monstruo en relación con los muros, otras criaturas y el caballero.
     * @param muros     Los muros en el calabozo.
     * @param creatures Las otras criaturas en el calabozo.
     * @param arthur    El caballero (jugador) en el calabozo.
     * @return   Retorna -1 si el monstruo colisiona con un muro, otra criatura o la espada del caballero.
     *           Retorna 0 si el monstruo colisiona con el caballero.
     *           Retorna 1 si el monstruo no colisiona con nada.
     */
    public int verificarMove(ArrayList<Wall> muros, ArrayList<Monster> creatures, Knight arthur) {
        for (Wall muro : muros) {
            if (this.checkCollision(muro)) {
                return -1;
            }
        }
        for (LivingBeing creature : creatures) {
            if (creature != this && this.checkCollision(creature) && !(creature instanceof Unicorn)) {
                return -1;
            }
        }
        if (this.checkCollision(arthur)) {
            return 0;
        }
        if (this.checkCollision(arthur.getSword())){
            return -1;
        }

        return 1;
    }
    
    
    /**
    * Cambia la dirección del monstruo de manera aleatoria.
    */
    private void changeDirection() {
        // Cambiar la dirección de manera aleatoria
        int randomDirection = (int) (Math.random() * 4);

        xLeMove = false;
        yUpMove = false;
        xRiMove = false;
        yDoMove = false;

        switch (randomDirection) {
            case 0:
                xLeMove = true;
                break;
            case 1:
                yUpMove = true;
                break;
            case 2:
                xRiMove = true;
                break;
            case 3:
                yDoMove = true;
                break;
        }
    }

    /**
     * Obtiene el dungeon al que pertenece el monstruo.
     * @return the dungeon
     */
    public Dungeon getDungeon() {
        return dungeon;
    }

    /**
     * Obtiene el valor de daño que hace el monstruo.
     * @return the damage
     */
    @Override
    public int getDamage() {
        return damage;
    }
    
    
}
