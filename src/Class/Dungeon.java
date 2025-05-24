/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;


import Armas.Weapon;
import Creature.Dragon;
import Creature.Monster;
import Creature.MonsterThread;
import dungeons.gui.Drawable;
import Knight.Assasin;
import Knight.Barbarian;
import Knight.Magician;
import Knight.Tank;
import Knight.SwordMan;
import Knight.Archer;
import Knight.Knight;
import dungeons.gui.GameOver;
import dungeons.gui.LevelCompleted;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Clase que representa el mapa del juego que contiene los muros y creaturas.
 * @author Santiago Jiménez
 * @author Daniel Felipe Lopez
 * @version 1.0.1
 */
public class Dungeon extends Sprite implements Drawable, Boundable{

    private Knight arthur;
    private Drawable drawable;
    private LectorArchivo lector;
    private ArrayList<Wall> muros;
    private ArrayList<Monster> creatures;
    private String nivel;
    private ImageIcon fondo = new ImageIcon("Background.png");
    private int score;
    private boolean active;
    private int llamado;
    

    /**
     *
     * @param x posición en x del mapa
     * @param y posición en y del mapa
     * @param width ancho del mapa
     * @param height altura del mapa
     * @param type tipo de caballero que sera utilizado.
     * @param nivel nivel o mapa que sera jugado.
     */
    public Dungeon(int x, int y, int width, int height, String type, String nivel) {
        super(x, y, width, height, new Color(186, 222, 248  ));
        arthur = createKnight(40, 40, type, this);
        lector = new LectorArchivo(nivel);
        muros = new ArrayList<>();
        creatures = new ArrayList<>(); 
        score = 1200;
        mapearDungeon();
        active = true;
        llamado = 0;
        arthur.setDrawable(this);
    }

    /**
     *
     * @param drawable
     */
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
    
    private void mapearDungeon() {
        this.muros = lector.leerMapa();
        this.creatures = lector.leerMonstruos(this);
        for (Monster monstruo : creatures) {
            monstruo.setDrawable(this);
        }
    }
    
    /**
     * Crea un caballero dependiendo del tipo de knight del mapa.
     * @param x posicion en  x de la creacion del caballero.
     * @param y posicion en y de la creacion del caballero.
     * @param type tipo de caballero a crear.
     * @return caballero creado.
     */
    

    public Knight createKnight (int x, int y, String type, Dungeon dungeon){
        Knight knight = null;
        if (type.equals("Assasin")){
            knight = new Assasin(x, y, dungeon);
        }
        else if (type.equals("Archer")){
            knight = new Archer(x, y, dungeon);
        }
        else if (type.equals("Barbarian")){
            knight = new Barbarian(x, y, dungeon);
        }
        else if (type.equals("Magician")){
            knight = new Magician(x, y, dungeon);
        }
        else if (type.equals("SwordMan")){
            knight = new SwordMan(x, y, dungeon);
        }
        else if (type.equals("Tank")){
            knight = new Tank(x, y, dungeon);
        }
        
        return knight;
    }

    /**
     * Dibuja el mapa o Dungeon en la ventana.
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        fondo.paintIcon(null, g, x, y);

        arthur.draw(g);
        if(arthur instanceof Magician){
            for (Weapon weapon : ((Magician) arthur).getFireballs()) {
                    weapon.draw(g);
                }
        }
        if(arthur instanceof Archer){
            for (Weapon weapon : ((Archer) arthur).getArrows()) {
                    weapon.draw(g);
                }
        }
         
        
        for (Wall muro : getMuros()){
            g.setColor(muro.getColor());
            g.fillRect(muro.getX(), muro.getY(), muro.getWidth(), muro.getHeight());
            muro.draw(g);
            if (arthur.getSword() != null){
                arthur.getSword().draw(g);
            }
        }
        if(getCreatures() != null){
        for (Monster monstruo : getCreatures()) {
            monstruo.draw(g);
          
            if (!monsterThreadIsRunning(monstruo)) {
                monstruo.setDungeon(this);
                MonsterThread thread = new MonsterThread(this, monstruo);
                thread.start();
            }
            
        }
        }else{
            this.active = false;
        }
        for (Monster creature : creatures) {
            if (creature instanceof Dragon) {
                for (Weapon weapon : ((Dragon) creature).getFireballs()) {
                    weapon.draw(g);
                }
            }
        }
        drawLife(g);
        drawScore(g);
    }
    
    private void drawLife(Graphics g){
        if (arthur.getHealth() > 0){
            int[] pos = {10, 770};
            String lifeToString = Integer.toString(arthur.getHealth());
            for (int i = 0; i < lifeToString.length(); i++) {
                int digit = Integer.parseInt(lifeToString.substring(i, i + 1));
                g.drawImage(Assets.numbers(digit), pos[0], pos[1], null);
                pos[0] = pos[0] + 20;
            }  
        }
        verificarPerder(llamado);
    }
    
    /**
     * Dibuja el score que lleva el personaje en el nivel.
     * @param g
     */
    public void drawScore(Graphics g){
        if (score >= 0){
            int[] pos = {580, 770};
            String scoreToString = Integer.toString(score);

            for (int i = 0; i < scoreToString.length(); i++) {
                int digit = Integer.parseInt(scoreToString.substring(i, i + 1));
                g.drawImage(Assets.numbers(digit), pos[0], pos[1], null);
                pos[0] = pos[0] + 20;
            }
        } else {
            llamado += 1;
            verificarPerder(llamado);
        }
    }

    /**
     *  
     * @param key
     */
    


public void actKnight(int key){
        if(key == KeyEvent.VK_W |
           key == KeyEvent.VK_S |
           key == KeyEvent.VK_A | 
           key == KeyEvent.VK_D |
           key == KeyEvent.VK_SPACE)       
        {
            getArthur().actionHandle(key, getMuros(), getCreatures());
            getDrawable().redraw(); // TODO
        }
    }
    
    public void verificarPerder(int llamado){
        if (arthur.getHealth() <= 0  && llamado == 1) {
            GameOver go = new GameOver(null, true);
            go.setVisible(true);
            this.active = false;
            this.score = 0;
            
            
        }
    }
    
    public void verificarVictoria(int llamado){
        if(this.creatures.isEmpty() && llamado == 1){
            LevelCompleted lc = new LevelCompleted(null, true);
            lc.setScore(String.valueOf(this.score));
            lc.setVisible(true);
            this.active = false;
        }
    }
    
    /**
     * Redibuja el mapa
     */
    @Override
    public void redraw() {
        drawable.redraw();
    }
    
    /**
     * Da valor al score.
     */
    public void setScore(){
        score = score - 1;
    }

    /**
     * Verifica si es valido el movimiento de un sprite.
     * @param sprite
     * @return
     */
    
    @Override
    public boolean isValid(Sprite sprite) {
        if(sprite.getX() < this.getX() |
           sprite.getY() < this.getY() |
           sprite.getX()+sprite.getWidth() > this.getX()+this.getWidth() |
           sprite.getY()+sprite.getHeight() > this.getY()+this.getHeight())
            return false;

        return true;
    }
    
    /**
     * Elimina una creatura que ha sido vencida.
     * @param index
     */
    public void quitarVidaCreature(int index, int daño){
        int posicion = 0; 
        for (int i =0; i<creatures.size();i++) {
            if (posicion == index){
                creatures.get(i).quitarVida(daño);
                if (creatures.get(i).getHealth() <= 0){
                    eliminarCreature(index);
                }
            }
        }
    }

    public void eliminarCreature(int index){
        this.getCreatures().remove(index);
    }
    /**
     * @return the arthur
     */
    public Knight getArthur() {
        return arthur;
    }

    /**
     * @return the drawable
     */
    public Drawable getDrawable() {
        return drawable;
    }

    /**
     * @return the muros
     */
    public ArrayList<Wall> getMuros() {
        return muros;
    }

    /**
     * @return the creatures
     */
    public ArrayList<Monster> getCreatures() {
        if (!creatures.isEmpty()){
            return creatures;
        } else {
            llamado+=1;
            verificarVictoria(llamado);
        }
        return null;
    }
    
    private boolean monsterThreadIsRunning(LivingBeing monstruo) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads, true);

        for (Thread thread : threads) {
            if (thread instanceof MonsterThread) {
                MonsterThread monsterThread = (MonsterThread) thread;
                if (monsterThread.getMonster() == monstruo) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }
   
}