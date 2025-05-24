/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Class.Dungeon;
import Armas.Fireball;
import Armas.Weapon;
import Knight.Knight;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Dragon que hereda de la clase Monster.
 * Representa un monstruo específico (Dragon) en el juego.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Dragon extends Monster{
    /**
     * Una lista de bolas de fuego que el Dragon puede lanzar.
     */
    private ArrayList<Fireball> fireballs;

    /**
     * Ancho del objeto Dragon.
     */
    public static final int WIDTH = 200;

    /**
     * Alto del objeto Dragon.
     */
    public static final int HEIGHT = 229;


    /**
     * Constructor de la clase Dragon.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     * @param x La coordenada x del Dragon.
     * @param y La coordenada y del Dragon.
     * @param dungeon  El calabozo en el que se encuentra el Dragon.
     */
    
    public Dragon(int x, int y, Dungeon dungeon) {
        super(x, y, WIDTH, HEIGHT, 1200, 15, 100, 1, new ImageIcon("Dragon.png"), dungeon);
        fireballs = new ArrayList<>();
    }

    /**
     * Método para que el Dragon ataque.
     * Crea una nueva bola de fuego y la mueve en la dirección especificada.
     * Si la bola de fuego colisiona con Arthur, le quita vida a Arthur.
     */
    
    @Override
    public void attack() {
    Fireball fireball = new Fireball(x, y+35, getDungeon(), "Fireball1.png");
    getFireballs().add(fireball);
    int ataque = -1;
    while (fireball.isInRange()) {
        fireball.move(2); // 2 representa la dirección hacia la izquierda
        getDungeon().redraw();
        ataque = verificarAtaque(getDungeon().getArthur(), fireball);
        if (ataque != -1){
            
            
            break;
            
        }
        try {
                    // Agregar un retraso de 100 milisegundos (ajusta según sea necesario)
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    }
    getFireballs().remove(fireball);
    }
    
    /**
     * Verifica si la bola de fuego ataca a Arthur.
     * @param arthur Arthur(jugador).
     * @param fireball La bola de fuego.
     * @return  1 si la bola de fuego ataca a Arthur, o -1 si no ataca a Arthur.
     */
    public int verificarAtaque(Knight arthur, Weapon fireball){
        
        
            if (fireball.checkCollision(arthur)) {
                getDungeon().getArthur().quitarVida(getDamage());
                return 1;
            }
            
        
        return -1;
    }
    

    /**
     * Dibuja el Dragon y sus bolas de fuego en el objeto Graphics proporcionado.
     * @param g El objeto Graphics en el que se dibuja el Dragon y sus bolas de fuego.
     */
    @Override
    public void draw(Graphics g) {
        super.draw(g);

        // Dibuja las bolas de fuego
        for (Fireball fireball : getFireballs()) {
            fireball.draw(g);
        }
    }

    /**
     * Obtiene la altura del Dragon.
     * @return La altura del Dragon.
     */
    @Override
    public int getHeight() {
        return HEIGHT;
    }

    /**
     * Obtiene el ancho del Dragon.
     * @return El ancho del Dragon.
     */
    @Override
    public int getWidth() {
        return WIDTH;
    }

    /**
     * Obtiene las bolas de fuego del Dragon.
     * @return Las bolas de fuego del Dragon.
     */
    public ArrayList<Fireball> getFireballs() {
        return fireballs;
    }
    
}
