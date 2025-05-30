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
 * Clase SwordMan que representa un caballero espadachín en el juego.
 * Hereda de Knight y permite atacar con una espada en diferentes direcciones.
 * Gestiona la creación, movimiento y verificación de ataques con la espada.
 *
 * @author Juan Sebastian Arias
 * @author Juan Jose Trujillo
 * @author Juan Jose Cardona
 * @version 1.0.2
 */
public class SwordMan extends Knight{
    /**
     * Constructor de la clase SwordMan.
     * Inicializa las propiedades del SwordMan con los valores proporcionados.
     *
     * @param x Coordenada x del SwordMan.
     * @param y Coordenada y del SwordMan.
     * @param dungeon El calabozo en el que se encuentra el SwordMan.
     */
    public SwordMan(int x, int y, Dungeon dungeon) {
        super(x, y, 22, 25, 100, 52, 30, 8,new ImageIcon("SwordmanCharacter.png"), dungeon);
    }

    /**
     * Permite que el SwordMan ataque a una criatura con una espada en la dirección actual.
     * Crea una nueva Espada, la mueve y verifica colisiones con criaturas.
     * Si la espada impacta, aplica daño.
     *
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
     *
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
