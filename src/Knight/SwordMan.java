/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Class.Dungeon;
import Armas.Espada;
import Armas.Weapon;
import Class.LivingBeing;
import Creature.Monster;
import Creature.Unicorn;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Swordman que hereda de la clase Knight.
 * Representa un personaje específico (Swordman) en un juego.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class SwordMan extends Knight{
    
    /**
     * Constructor de la clase Swordman.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     * @param x  La coordenada x del Swordman.
     * @param y  La coordenada y del Swordman.
     * @param dungeon  El calabozo en el que se encuentra el Swordman.
     */
    public SwordMan(int x, int y, Dungeon dungeon) {
        super(x, y, 22, 25, 100, 62, 60, 8,new ImageIcon("SwordmanCharacter.png"), dungeon);
    }

    /**
     * Método para que el Swordman ataque.
     * Dependiendo de la dirección de ataque, crea una nueva espada y verifica si ataca a alguna criatura.
     * Si ataca a alguna criatura, quita vida a la criatura atacada.
     * @param creatures Las criaturas en el calabozo.
     */
    @Override
    public void attackArthur(ArrayList<Monster> creatures) {
        int ataque = -1;
        switch (getAtaqueDireccion()) {
            case 0 -> {
                sword = new Espada(x+(width/2),(y-17), 9, 17, getDungeon(), "Sword.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 1 -> {
                sword = new Espada(x+(width/2), (y+height), 9, 17, getDungeon(), "Sword3.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 2 -> {
                sword = new Espada((x-9), y+(height/2), 17, 9, getDungeon(), "Sword4.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 3 -> {
                sword = new Espada((x+width), y+(height/2), 17, 9, getDungeon(), "Sword2.png");
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
     * Verifica si la espada ataca a alguna criatura.
     * @param creatures Las criaturas en el calabozo.
     * @param espada La espada con la que se está atacando.
     * @return El índice de la criatura atacada, o -1 si no ataca a ninguna criatura.
     */
    @Override
    public int verificarAtaque(ArrayList<Monster> creatures, Weapon espada){
        int i = 0;
        for (Monster creature : creatures) {
            if (espada.checkCollision(creature) && !(creature instanceof Unicorn)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
