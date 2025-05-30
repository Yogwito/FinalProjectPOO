/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Knight;

import dungeons.gui.GameOver;
import Class.Boundable;
import Class.Dungeon;
import Armas.Espada;
import Armas.Weapon;
import Class.LivingBeing;
import Class.Wall;
import Creature.Monster;
import Creature.Unicorn;
import dungeons.gui.Downgrade;
import dungeons.gui.Drawable;
import dungeons.gui.Upgrade;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Clase Knight que extiende de LivingBeing.
 * Esta clase representa un caballero en el juego.
 * @author Juan Sebastian Arias
 * @author Juan Jose Trujillo
 * @author Juan Jose Cardona
 * @version 1.0.2
 */
public class Knight extends LivingBeing{
    
    /**
     * Salud del caballero.
     */
    private int health;

    /**
     * Daño que puede infligir el caballero.
     */
    private int damage;
    
    int direccion = 0;

    /**
     * Rango de ataque del caballero.
     */
    private int range;

    /**
     * Velocidad de movimiento del caballero.
     */
    private int speed;

    /**
     * Imagen que representa al caballero.
     */
    private ImageIcon image;

    /**
     * Calabozo en el que se encuentra el caballero.
     */
    Dungeon dungeon;

    /**
     * Dirección de ataque del caballero.
     */
    private int ataqueDireccion;

    /**
     * Arma del caballero.
     */
    Weapon sword;
    
    /**
     * Constructor de la clase Knight.
     * @param x Coordenada x del caballero en el tablero.
     * @param y Coordenada y del caballero en el tablero.
     * @param width Ancho del caballero.
     * @param height Alto del caballero.
     * @param health Salud del caballero.
     * @param damage Daño que puede infligir el caballero.
     * @param range Rango de ataque del caballero.
     * @param speed Velocidad de movimiento del caballero.
     * @param image Imagen que representa al caballero.
     * @param dungeon Calabozo en el que se encuentra el caballero.
     */
    public Knight(int x, int y, int width, int height, int health, int damage, int range, int speed ,ImageIcon image, Dungeon dungeon) {
        super(x, y, width, height, health, damage, range, speed, image, dungeon);
        this.health = health;
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.image = image;
        this.dungeon = dungeon;
        ataqueDireccion = 0;
        this.sword = null;
    }
    
    /**
     * Método para manejar las acciones del caballero.
     * @param key Tecla presionada.
     * @param muros Lista de muros en el calabozo.
     * @param creatures Lista de criaturas en el calabozo.
     */
    public void actionHandle(int keyCode, ArrayList<Wall> muros, ArrayList<Monster> creatures) {
        switch (keyCode) {
            case KeyEvent.VK_W -> moveUp(muros);
            case KeyEvent.VK_S -> moveDown(muros);
            case KeyEvent.VK_A -> moveLeft(muros);
            case KeyEvent.VK_D -> moveRight(muros);
            case KeyEvent.VK_SPACE -> attackArthur(creatures);
        }
    }

    
    /**
    * Método para mover al caballero en el juego.
    * @param key Tecla presionada.
    * @param muros Lista de muros en el calabozo.
    * @param creatures Lista de criaturas en el calabozo.
    * @return Verdadero si el caballero puede moverse, falso en caso contrario.
    */
    public boolean move(int key, ArrayList<Wall> muros, ArrayList<Monster> creatures){
        int xOriginal = x;
        int yOriginal = y;

        if(key == KeyEvent.VK_W){
            sword = null;
            y -= speed;
            ataqueDireccion = 0;
            direccion = 0;
        }
        if(key == KeyEvent.VK_S){
            sword = null;
            y += speed;
            ataqueDireccion = 1;
            direccion = 1;
        }
        if(key == KeyEvent.VK_A){
            sword = null;
            x -= speed;
            ataqueDireccion = 2;
            direccion = 2;
        }
    if(key == KeyEvent.VK_D){
        sword = null;
        x += speed;
        ataqueDireccion = 3;
        direccion = 3;
    }

    for(Wall muro : muros){
        if(this.checkCollision(muro)) {
            this.setX(xOriginal);
            this.setY(yOriginal);
            return false;
        }
    }

    int i = 0;
    for(Monster monster : creatures){
        if(this.checkCollision(monster) && !(monster instanceof Unicorn)) {
            this.setX(xOriginal);
            this.setY(yOriginal);
            this.recibirDano(monster.getDamage());
            return false;
        }
        else if (this.checkCollision(monster) && monster instanceof Unicorn){
            getDungeon().eliminarCreature(i);
            int random = (int) (Math.random() * 2);
            int randomupgrade = (int) (Math.random() * 3);
            if(random == 0){
                Upgrade u = new Upgrade(null, true);
                u.setVisible(true);
                switch (randomupgrade) {
                    case 0 -> {
                        setHealth(getHealth()+10);
                        JOptionPane.showMessageDialog(null, "Health Upgrade");
                    }
                    case 1 -> {
                        setDamage(getDamage()+10);
                        JOptionPane.showMessageDialog(null, "Damage Upgrade");
                    }
                    case 2 -> {
                        setSpeed(getSpeed()+1);
                        JOptionPane.showMessageDialog(null, "Speed Upgrade");
                    }
                }
            }
            if(random == 1){
                Downgrade d = new Downgrade(null, true);
                d.setVisible(true);
                switch (randomupgrade) {
                    case 0 -> {
                        setHealth(getHealth()-10);
                        JOptionPane.showMessageDialog(null, "Health Downgrade");
                    }
                    case 1 -> {
                        setDamage(getDamage()-10);
                        JOptionPane.showMessageDialog(null, "Damage Downgrade");
                    }
                    case 2 -> {
                        setSpeed(getSpeed()-1);
                        JOptionPane.showMessageDialog(null, "Speed Downgrade");
                    }
                }
            }
            return true;
        }
        i++;
    }

    return true;
}
    
    /**
    * Método para que el caballero ataque a las criaturas.
    * @param creatures Lista de criaturas a las que el caballero puede atacar.
    */
    public void attackArthur(ArrayList<Monster> creatures){
        
    }
    
    /**
    * Método para verificar si el caballero ha atacado a alguna criatura con su arma.
    * @param creatures Lista de criaturas a verificar.
    * @param arma Espada del caballero.
    * @return 0 (este método aún no está implementado).
    */
    public int verificarAtaque(ArrayList<Monster> creatures, Weapon arma){
        return 0;
    }

    /**
    * Obtiene la dirección de ataque del caballero.
    * @return Dirección de ataque del caballero.
    */
    public int getAtaqueDireccion() {
       return ataqueDireccion;
    }

   /**
    * Obtiene la Arma del caballero.
    * @return Arma del caballero.
    */
    public Weapon getSword() {
       return sword;
    }

    /**
    * Obtiene el calabozo en el que se encuentra el caballero.
    * @return Calabozo en el que se encuentra el caballero.
    */
    public Dungeon getDungeon() {
        return dungeon;
    }

    private void moveUp(ArrayList<Wall> muros) {
        move(KeyEvent.VK_W, muros, dungeon.getCreatures());
    }

    private void moveDown(ArrayList<Wall> muros) {
        move(KeyEvent.VK_S, muros, dungeon.getCreatures());
    }

    private void moveLeft(ArrayList<Wall> muros) {
        move(KeyEvent.VK_A, muros, dungeon.getCreatures());
    }

    private void moveRight(ArrayList<Wall> muros) {
        move(KeyEvent.VK_D, muros, dungeon.getCreatures());
    }
    @Override
    public void morir() {
        dungeon.setActive(false);
        GameOver gameOver = new GameOver(null, true, dungeon.getNivel(), dungeon.getTipo(), dungeon.getNombreJugador());
        gameOver.setVisible(true);
    }

    public int getDireccion() {
        return this.direccion;
}
}
