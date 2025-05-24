/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Armas.Daga;
import Class.Dungeon;
import Armas.Espada;
import Armas.Weapon;
import Creature.Monster;
import Creature.Unicorn;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Assasin que hereda de la clase Knight.
 * Representa un personaje específico (Assasin) en un juego.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Assasin extends Knight{
    
    /**
     * Constructor de la clase Assasin.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     * @param x  La coordenada x del Assasin.
     * @param y  La coordenada y del Assasin.
     * @param dungeon  El calabozo en el que se encuentra el Assasin.
     */
     public Assasin(int x, int y, Dungeon dungeon) {
        super(x, y,20,28, 100, 175, 10, 10 , new ImageIcon("AssasinCharacter.png"), dungeon);
    }

    /**
     * Método para que el Assasin ataque.
     */
    @Override
    public void attack() {
        super.attack();
    }
    
    /**
     * Método para que el Assasin ataque.
     * Dependiendo de la dirección de ataque, crea una nueva Daga y verifica si ataca a alguna criatura.
     * Si ataca a alguna criatura, quita vida a la criatura atacada.
     * @param creatures Las criaturas en el calabozo.
     */
    @Override
    public void attackArthur(ArrayList<Monster> creatures) {
        int ataque = -1;
        System.out.println("Espada1");
        switch (getAtaqueDireccion()) {
            case 0 -> {
                sword = new Daga(x+(width/2),(y-17), 9, 17, getDungeon(), "daga1.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 1 -> {
                sword = new Daga(x+(width/2), (y+height), 9, 17, getDungeon(), "daga3.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 2 -> {
                sword = new Daga((x-9), y+(height/2), 17, 9, getDungeon(), "daga4.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 3 -> {
                sword = new Daga((x+width), y+(height/2), 17, 9, getDungeon(), "daga2.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            default -> {
            }
        }
    }
    
    /**
     * Verifica si la daga ataca a alguna criatura.
     * @param creatures Las criaturas en el calabozo.
     * @param daga La daga con la que se está atacando.
     * @return El índice de la criatura atacada, o -1 si no ataca a ninguna criatura.
     */
     @Override
    public int verificarAtaque(ArrayList<Monster> creatures, Weapon daga){
        int i = 0;
        for (Monster creature : creatures) {
            if (daga.checkCollision(creature) && !(creature instanceof Unicorn)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
