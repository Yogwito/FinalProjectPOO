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
 * Clase Archer que representa un caballero arquero en el juego.
 * Hereda de Knight y permite lanzar flechas (Arrow) como ataque a las criaturas.
 * Gestiona la creación, movimiento y dibujo de las flechas disparadas.
 *
 * @author Juan Sebastian Arias
 * @author Juan Jose Trujillo
 * @author Juan Jose Cardona
 * @version 1.0.2
 */
public class Archer extends Knight {
    /**
     * Lista de flechas que el Archer puede lanzar.
     */
    private ArrayList<Arrow> arrows = new ArrayList<>();

    /**
     * Constructor de la clase Archer.
     * Inicializa las propiedades del Archer con los valores proporcionados.
     *
     * @param x Coordenada x del Archer.
     * @param y Coordenada y del Archer.
     * @param dungeon El calabozo en el que se encuentra el Archer.
     */
    public Archer(int x, int y, Dungeon dungeon) {
        super(x, y, 40, 40, 100, 15, 10, 4, new ImageIcon("ArcherCharacter.png"), dungeon);
    }
    
    /**
     * Permite que el Archer ataque a una criatura lanzando una flecha en la dirección actual.
     * Crea una nueva flecha, la mueve y verifica colisiones con criaturas.
     * Si la flecha impacta, aplica daño y elimina la flecha.
     *
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
     * Dibuja el Archer y todas sus flechas en el objeto Graphics proporcionado.
     *
     * @param g El objeto Graphics en el que se dibuja el Archer y sus flechas.
     */
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        for (Arrow arrow : arrows) {
            arrow.draw(g);
        }
        
    }

    /**
     * Obtiene la lista de flechas del Archer.
     *
     * @return Lista de flechas del Archer.
     */
    public ArrayList<Arrow> getArrows() {
        return arrows;
    }

    /**
     * Establece la lista de flechas del Archer.
     *
     * @param arrows Las flechas a establecer.
     */
    public void setArrows(ArrayList<Arrow> arrows) {
        this.arrows = arrows;
    }

}

