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
 * Clase Barbarian que representa un caballero bárbaro en el juego.
 * Hereda de Knight y permite atacar con un hacha en diferentes direcciones.
 * Gestiona la creación, movimiento y verificación de ataques con el hacha.
 *
 * @author Juan Sebastian Arias
 * @author Juan Jose Trujillo
 * @author Juan Jose Cardona
 * @version 1.0.2
 */
public class Barbarian extends Knight{
    /**
     * Constructor de la clase Barbarian.
     * Inicializa las propiedades del Barbarian con los valores proporcionados.
     *
     * @param x Coordenada x del Barbarian.
     * @param y Coordenada y del Barbarian.
     * @param dungeon El calabozo en el que se encuentra el Barbarian.
     */
    public Barbarian(int x, int y, Dungeon dungeon) {
        super(x, y, 20, 30, 120, 70, 17, 5, new ImageIcon("BarbarianCharacter.png"), dungeon);
    }
    
    /**
     * Permite que el Barbarian ataque a una criatura con un hacha en la dirección actual.
     * Crea una nueva Acha, la mueve y verifica colisiones con criaturas.
     * Si el hacha impacta, aplica daño.
     *
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
     * Verifica si el hacha ataca a alguna criatura.
     *
     * @param creatures Las criaturas en el calabozo.
     * @param acha El hacha con la que se está atacando.
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
