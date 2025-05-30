/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Armas.Acha;
import Armas.Fireball;
import Class.Dungeon;
import Armas.Fireball;
import Class.LivingBeing;
import Class.Sprite;
import Creature.Monster;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Clase Magician que representa un caballero mago en el juego.
 * Hereda de Knight y permite lanzar bolas de fuego (Fireball) como ataque a las criaturas.
 * Gestiona la creación, movimiento y dibujo de las bolas de fuego lanzadas.
 *
 * @author Juan Sebastian Arias
 * @author Juan Jose Trujillo
 * @author Juan Jose Cardona
 * @version 1.0.2
 */
public class Magician extends Knight{
    /**
     * Lista de bolas de fuego que el mago puede lanzar.
     */
    private ArrayList<Fireball> fireballs = new ArrayList<>();
    
    /**
     * Constructor de la clase Magician.
     * Inicializa las propiedades del mago con los valores proporcionados.
     *
     * @param x Coordenada x del mago en el tablero.
     * @param y Coordenada y del mago en el tablero.
     * @param dungeon El calabozo en el que se encuentra el mago.
     */
    public Magician(int x, int y, Dungeon dungeon) {
        super(x, y, 16, 29, 80, 40, 100, 5, new ImageIcon("MagicianCharacter.png"), dungeon);
    }
    
    /**
     * Permite que el Magician ataque a una criatura lanzando una bola de fuego en la dirección actual.
     * Crea una nueva bola de fuego, la mueve y verifica colisiones con criaturas.
     * Si la bola de fuego impacta, aplica daño y elimina la bola de fuego.
     *
     * @param creatures Las criaturas en el calabozo.
     */
    @Override
public void attackArthur(ArrayList<Monster> creatures) {
    Fireball fireball = null;

    switch (direccion) {
        case 0 -> fireball = new Fireball(x + (width / 2), y - 17, getDungeon(), "Fireball1.png");
        case 1 -> fireball = new Fireball(x + (width / 2), y + height, getDungeon(), "Fireball1.png");
        case 2 -> fireball = new Fireball(x - 9, y + (height / 2), getDungeon(), "Fireball1.png");
        case 3 -> fireball = new Fireball(x + width, y + (height / 2), getDungeon(), "Fireball1.png");
    }

    if (fireball != null) {
        fireball.setDrawable(this.getDrawable()); // importante
        getFireballs().add(fireball); // si estás manejando una lista propia

        Fireball finalFireball = fireball;
        new Thread(() -> {
            while (finalFireball.isInRange()) {
                finalFireball.move(direccion);
                verificarAtaque(creatures, finalFireball);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    break;
                }
            }
            getFireballs().remove(finalFireball); // quítala de tu lista, no del dungeon
        }).start();
    }
}
    
    /**
     * Dibuja el mago y todas sus bolas de fuego en el objeto Graphics proporcionado.
     *
     * @param g Objeto Graphics para dibujar al mago y sus bolas de fuego.
     */
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        for (Fireball fireball : fireballs) {
            fireball.draw(g);
        }
        
    }
    
    /**
     * Obtiene la lista de bolas de fuego del mago.
     *
     * @return Lista de bolas de fuego del mago.
     */
    public ArrayList<Fireball> getFireballs() {
        return fireballs;
    }



}
