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
 * Clase Magician que extiende de Knight.
 * Esta clase representa un mago en el juego.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Magician extends Knight{
    /**
     * Lista de bolas de fuego que el mago puede lanzar.
     */
    private ArrayList<Fireball> fireballs = new ArrayList<>();
    
    /**
     * Constructor de la clase Magician.
     * @param x Coordenada x del mago en el tablero.
     * @param y Coordenada y del mago en el tablero.
     * @param dungeon El calabozo en el que se encuentra el mago.
     */

    public Magician(int x, int y, Dungeon dungeon) {
        super(x, y, 16, 29, 80, 80, 250, 5, new ImageIcon("MagicianCharacter.png"), dungeon);
    }
    
    /**
     * Método para que el Magician ataque a una creature.
     * Crea una nueva bola de fuego y la mueve en la dirección especificada.
     * Si la bola de fuego colisiona con alguna criatura, le quita vida a la criatura.
     * @param creatures Las criaturas en el calabozo.
     */
    public void attackArthur(ArrayList<Monster> creatures) {
    int ataque = -1;
        System.out.println("atacando");
    
    switch (getAtaqueDireccion()) {
      case 0 -> {
        Fireball fireball = new Fireball(x+(width/2),(y-17),getDungeon(), "Fireball.png");
        fireball.setDrawable(this.getDrawable());
        getFireballs().add(fireball);
        while (fireball.isInRange()) {
          fireball.move(0);
            System.out.println("se mueve:");
          dungeon.redraw();
          ataque = verificarAtaque(creatures, fireball);
          if (ataque != -1){
            getDungeon().quitarVidaCreature(ataque, getDamage());
            
              System.out.println("le di");
            break;
            
          }
          try {
                    // Agregar un retraso de 100 milisegundos (ajusta según sea necesario)
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        getFireballs().remove(fireball);
      }
      case 1 -> {
        Fireball fireball = new Fireball(x+(width/2), (y+height),getDungeon(), "Fireball.png");
        fireball.setDrawable(this.getDrawable());
        getFireballs().add(fireball);
        while (fireball.isInRange()) {
          fireball.move(1);
          
          dungeon.redraw();
          ataque = verificarAtaque(creatures, fireball);
          if (ataque != -1){
            getDungeon().quitarVidaCreature(ataque, getDamage());
            
            break;
          }
          try {
                    // Agregar un retraso de 100 milisegundos (ajusta según sea necesario)
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        getFireballs().remove(fireball);
      }
      case 2 -> {
        Fireball fireball = new Fireball((x-9), y+(height/2), getDungeon(), "Fireball.png");
        fireball.setDrawable(this.getDrawable());
        getFireballs().add(fireball);
        while (fireball.isInRange()) {
          fireball.move(2);
          
          dungeon.redraw();
          ataque = verificarAtaque(creatures, fireball);
          if (ataque != -1){
            getDungeon().quitarVidaCreature(ataque, getDamage());
            
            break;
          }
          try {
                    // Agregar un retraso de 100 milisegundos (ajusta según sea necesario)
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        getFireballs().remove(fireball);
      }
      case 3 -> {
        Fireball fireball = new Fireball((x+width), y+(height/2), getDungeon(), "Fireball.png");
        fireball.setDrawable(this.getDrawable());
        getFireballs().add(fireball);
        while (fireball.isInRange()) {
          fireball.move(3);
            
          dungeon.redraw();
          ataque = verificarAtaque(creatures, fireball);
          if (ataque != -1){
            getDungeon().quitarVidaCreature(ataque, getDamage());
            
            break;
          }
          try {
                    // Agregar un retraso de 100 milisegundos (ajusta según sea necesario)
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        getFireballs().remove(fireball);
      }
      default -> {
      }
    }
        
  }
    
    /**
     * Método para dibujar al mago en el tablero.
     * @param g Objeto Graphics para dibujar al mago.
     */
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        for (Fireball fireball : fireballs) {
            fireball.draw(g);
        }
        
    }

    /**
     * Obtiene las bolas de fuego del mago.
     * @return Lista de bolas de fuego del mago.
     */
    public ArrayList<Fireball> getFireballs() {
        return fireballs;
    }



}
