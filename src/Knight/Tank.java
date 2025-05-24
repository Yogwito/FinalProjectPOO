/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Armas.Escudo;
import Class.Dungeon;
import Armas.Espada;
import Armas.Weapon;
import Creature.Monster;
import Creature.Unicorn;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Tank que hereda de la clase Knight.
 * Representa un personaje específico (Tank) en un juego.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Tank extends Knight{
    
    /**
     * Constructor de la clase Tank.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     * @param x  La coordenada x del Tank.
     * @param y  La coordenada y del Tank.
     * @param dungeon  El calabozo en el que se encuentra el Tank.
     */
    public Tank(int x, int y, Dungeon dungeon) {
        super(x, y, 20, 30, 150, 32, 15, 3,new ImageIcon("TankCharacter1.png"), dungeon);
    }

    /**
     * Método para que el Tank ataque.
     * Dependiendo de la dirección de ataque, crea un nuevo escudo y verifica si ataca a alguna criatura.
     * Si ataca a alguna criatura, quita vida a la criatura atacada.
     * @param creatures Las criaturas en el calabozo.
     */
    @Override
    public void attackArthur(ArrayList<Monster> creatures) {
        int ataque = -1;
        System.out.println("Espada1");
        switch (getAtaqueDireccion()) {
            case 0 -> {
                sword = new Escudo(x+(width/2),(y-17), 9, 17, getDungeon(), "escudo3.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 1 -> {
                sword = new Escudo(x+(width/2), (y+height), 9, 17, getDungeon(), "escudo1.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 2 -> {
                sword = new Escudo((x-9), y+(height/2), 17, 9, getDungeon(), "escudo2.png");
                ataque = verificarAtaque(creatures, getSword());
                if (ataque != -1){
                    getDungeon().quitarVidaCreature(ataque, getDamage());
                }
            }
            case 3 -> {
                sword = new Escudo((x+width), y+(height/2), 17, 9, getDungeon(), "escudo4.png");
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
     * Verifica si el escudo ataca a alguna criatura.
     * @param creatures Las criaturas en el calabozo.
     * @param escudo El escudo con la que se está atacando.
     * @return El índice de la criatura atacada, o -1 si no ataca a ninguna criatura.
     */
    @Override
    public int verificarAtaque(ArrayList<Monster> creatures, Weapon escudo){
        int i = 0;
        for (Monster creature : creatures) {
            if (escudo.checkCollision(creature) && !(creature instanceof Unicorn)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
