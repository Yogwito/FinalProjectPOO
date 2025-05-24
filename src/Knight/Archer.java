/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import Armas.Arrow;
import Class.Dungeon;
import Class.LivingBeing;
import Class.Sprite;
import Creature.Monster;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Esta es una clase Archer que hereda de la clase Knight.
 * Representa un personaje específico (Archer) en el juego.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.2
 */
public class Archer extends Knight {
    /**
     * Una lista de flechas que el Archer puede lanzar.
     */
    private ArrayList<Arrow> arrows = new ArrayList<>();

    /**
     * Constructor de la clase Archer.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     * @param x  La coordenada x del Archer.
     * @param y  La coordenada y del Archer.
     * @param dungeon  El calabozo en el que se encuentra el Archer.
     */
    public Archer(int x, int y, Dungeon dungeon) {
        super(x, y, 23, 28, 100, 40, 350, 10, new ImageIcon("ArcherCharacter.png"), dungeon);
    }


    
    /**
     * Método para que el Archer ataque a una creature.
     * Crea una nueva flecha y la mueve en la dirección especificada.
     * Si la flecha colisiona con alguna criatura, le quita vida a la criatura.
     * @param creatures Las criaturas en el calabozo.
     */
    @Override
    public void attackArthur(ArrayList<Monster> creatures) {
    int ataque = -1;
    
    switch (getAtaqueDireccion()) {
      case 0 -> {
        Arrow arrow = new Arrow(x+(width/2),(y-17),getDungeon(), "Arrow1.png");
        getArrows().add(arrow);
        
        while (arrow.isInRange()) {
          arrow.move(0);
          getDungeon().redraw();
          ataque = verificarAtaque(creatures, arrow);
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
        getArrows().remove(arrow);
      }
      case 1 -> {
        Arrow arrow = new Arrow(x+(width/2), (y+height),getDungeon(), "Arrow3.png");
        getArrows().add(arrow);
        while (arrow.isInRange()) {
          arrow.move(1);
          getDungeon().redraw();
          ataque = verificarAtaque(creatures, arrow);
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
        getArrows().remove(arrow);
      }
      case 2 -> {
        Arrow arrow = new Arrow((x-9), y+(height/2), getDungeon(), "Arrow4.png");
        getArrows().add(arrow);
        while (arrow.isInRange()) {
          arrow.move(2);
          getDungeon().redraw();
          ataque = verificarAtaque(creatures, arrow);
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
        getArrows().remove(arrow);
      }
      case 3 -> {
        Arrow arrow = new Arrow((x+width), y+(height/2), getDungeon(), "Arrow2.png");
        getArrows().add(arrow);
        while (arrow.isInRange()) {
          arrow.move(3);
          getDungeon().redraw();
          ataque = verificarAtaque(creatures, arrow);
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
        getArrows().remove(arrow);
      }
      default -> {
      }
    }
        
  }
    /**
     * Dibuja el Archer en el objeto Graphics proporcionado.
     * @param g El objeto Graphics en el que se dibuja el Archer.
     */
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        for (Arrow arrow : arrows) {
            arrow.draw(g);
        }
        
    }

    

    /**
     * Obtiene las flechas del Archer.
     * @return Las flechas del Archer.
     */
    public ArrayList<Arrow> getArrows() {
        return arrows;
    }

    /**
     * Establece las flechas del Archer.
     * @param arrows Las flechas a establecer.
     */
    public void setArrows(ArrayList<Arrow> arrows) {
        this.arrows = arrows;
    }

}

