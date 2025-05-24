/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Armas.Acha;
import Class.Dungeon;
import Armas.Espada;
import Armas.Weapon;
import Creature.Monster;
import Creature.Unicorn;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Barbarian que hereda de la clase Knight.
 * Representa un personaje específico (Barbarian) en un juego.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Barbarian extends Knight{
    
    /**
     * Constructor de la clase Barbarian.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     * @param x  La coordenada x del Barbarian.
     * @param y  La coordenada y del Barbarian.
     * @param dungeon  El calabozo en el que se encuentra el Barbarian.
     */
    public Barbarian(int x, int y, Dungeon dungeon) {
        super(x, y, 20, 30, 120, 100, 20, 5, new ImageIcon("BarbarianCharacter.png"), dungeon);
    }
    
    /**
     * Método para que el Barbarian ataque.
     * Dependiendo de la dirección de ataque, crea una nueva acha y verifica si ataca a alguna criatura.
     * Si ataca a alguna criatura, quita vida a la criatura atacada.
     * @param creatures Las criaturas en el calabozo.
     */
    @Override
    public void attackArthur(ArrayList<Monster> creatures) {
        int ataque = -1;
        System.out.println("Espada1");
        switch (getAtaqueDireccion()) {
            case 0 -> {
                sword = new Acha(x+(width/2),(y-17), 9, 17, getDungeon(), "Axe1.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 1 -> {
                sword = new Acha(x+(width/2), (y+height), 9, 17, getDungeon(), "Axe3.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 2 -> {
                sword = new Acha((x-9), y+(height/2), 17, 9, getDungeon(), "Axe4.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 3 -> {
                sword = new Acha((x+width), y+(height/2), 17, 9, getDungeon(), "Axe2.png");
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
     * Verifica si el acha ataca a alguna criatura.
     * @param creatures Las criaturas en el calabozo.
     * @param acha El acha con la que se está atacando.
     * @return El índice de la criatura atacada, o -1 si no ataca a ninguna criatura.
     */
    @Override
    public int verificarAtaque(ArrayList<Monster> creatures, Weapon acha){
        int i = 0;
        for (Monster creature : creatures) {
            if (acha.checkCollision(creature) && !(creature instanceof Unicorn)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
