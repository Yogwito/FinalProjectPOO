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
import dungeons.gui.Game;
import dungeons.gui.GameOver;
import dungeons.gui.LevelCompleted;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;
import dungeons.gui.MenuPrincipal;
import javax.swing.JFrame;

/**
 * Clase Dungeon que representa el mapa del juego, conteniendo muros, criaturas y al caballero principal.
 * Gestiona la lógica de dibujo, interacción, estado del juego, score, vida, victoria y derrota.
 * Permite crear el caballero según el tipo, mapear el dungeon desde archivos y controlar la validez de movimientos.
 *
 * @author Juan José Cardona Daza
 * @author Juan Sebastian Arias
 * @author Juan José Trujillo
 * @version 1.0.1
 */
public class Dungeon extends Sprite implements Drawable, Boundable{
    /** Caballero principal del dungeon. */
    private Knight arthur;
    /** Drawable asociado para redibujar el dungeon. */
    private Drawable drawable;
    /** Lector de archivos para mapear el dungeon. */
    private LectorArchivo lector;
    /** Lista de muros del dungeon. */
    private ArrayList<Wall> muros;
    /** Lista de criaturas del dungeon. */
    private ArrayList<Monster> creatures;
    /** Nombre del nivel actual. */
    private String nivel;
    /** Imagen de fondo del dungeon. */
    private ImageIcon fondo = new ImageIcon("Background.png");
    /** Puntaje actual del jugador. */
    private int score;
    /** Indica si el dungeon está activo. */
    private boolean active;
    /** Contador de llamadas para triggers únicos. */
    private int llamado;
    /** Tipo de caballero seleccionado. */
    private String tipo;
    /** Nombre del jugador. */
    private String nombreJugador;
    /** Indica si el juego está en pausa. */
    private boolean isPaused = false;
    /** Lista de hilos de monstruos activos. */
    private ArrayList<MonsterThread> monsterThreads = new ArrayList<>();
    /** Instancia de Game asociada a este dungeon. */
    private Game game;

    

    /**
     *
     * @param x posición en x del mapa
     * @param y posición en y del mapa
     * @param width ancho del mapa
     * @param height altura del mapa
     * @param type tipo de caballero que sera utilizado.
     * @param nivel nivel o mapa que sera jugado.
     */
    
    public Dungeon(int x, int y, int width, int height, String type, String nivel, String tipo) {
        super(x, y, width, height, new Color(186, 222, 248));
        this.tipo = tipo;
        this.nivel = nivel;
        this.score = 1200;
        this.active = true;
        this.llamado = 0;
        this.nombreJugador =  nombreJugador;

        lector = new LectorArchivo(nivel);
        muros = new ArrayList<>();
        creatures = new ArrayList<>();

        arthur = createKnight(40, 40, type, this);
        arthur.setDrawable(this);

        mapearDungeon();
    }
    public Dungeon(int x, int y, int width, int height, String tipo, String nivel) {
        this(x, y, width, height, tipo, nivel, tipo); // usa 'tipo' para ambos
    }

    /**
     * Dibuja la vida actual del caballero en pantalla.
     * @param g Objeto Graphics donde se dibuja la vida.
     */
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
     *
     * @param drawable
     */
    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
    
    /**
     * Obtiene el nombre del jugador actual.
     * @return Nombre del jugador.
     */
    public String getNombreJugador() {
        return nombreJugador;
    }
    
    /**
     * Mapea el dungeon leyendo muros y monstruos desde archivo.
     */
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
                monsterThreads.add(thread);

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
    
    /**
     * Dibuja el score (puntaje) actual del jugador en pantalla.
     * Si el score es negativo, incrementa el contador de llamados y verifica si el jugador ha perdido.
     * @param g Objeto Graphics donde se dibuja el puntaje.
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
     * Maneja la acción del caballero (Knight) según la tecla presionada.
     * Si se presiona 'Q', guarda el puntaje y regresa al menú principal.
     * Si se presiona 'ESC', alterna el estado de pausa.
     * Si el juego está activo y no en pausa, procesa los movimientos y acciones del caballero.
     * @param key Código de la tecla presionada.
     */
    
    public void actKnight(int key) {
        if (key == KeyEvent.VK_Q) {
            this.active = false;
            RegistroPartida registro = new RegistroPartida();
            registro.guardar(nombreJugador, score);

            JFrame frame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor((java.awt.Component) drawable);
            if (frame != null) frame.dispose();

            new MenuPrincipal().setVisible(true);
            return;
        }

        // ESC = alternar pausa
        if (key == KeyEvent.VK_ESCAPE) {
            isPaused = !isPaused;
            System.out.println(isPaused ? "⏸️ Juego pausado" : "▶️ Juego reanudado");
            return;
        }

        // Si está pausado o no activo, ignorar todo
        if (isPaused || !active) return;

        // Acciones normales
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_S ||
            key == KeyEvent.VK_A || key == KeyEvent.VK_D ||
            key == KeyEvent.VK_SPACE) {
            arthur.actionHandle(key, muros, creatures);
            drawable.redraw();
        }
    }

    /**
     * Detiene todos los hilos de monstruos activos en la lista monsterThreads.
     */
    public void detenerHilos() {
        for (MonsterThread hilo : monsterThreads) {
            hilo.detener(); // llama al método que apaga el scheduler
        }
        monsterThreads.clear();
    }

    /**
     * Verifica si el jugador ha perdido y muestra la pantalla de Game Over si corresponde.
     * @param llamado Número de llamadas para evitar múltiples triggers
     */
    public void verificarPerder(int llamado) {
        if (arthur.getHealth() <= 0 && llamado == 1) {
            this.active = false;
            this.isPaused = true;
            this.score = 0;

            this.detenerHilos();

            // Cerramos la ventana del juego
            if (game != null) game.dispose();

            // Ahora sí mostramos GameOver
            GameOver go = new GameOver(null, true, nivel, arthur.getClass().getSimpleName(), nombreJugador, null);
            go.setVisible(true);
        }
    }

    /**
     * Verifica si el jugador ha ganado el nivel y muestra la pantalla de LevelCompleted si corresponde.
     * @param llamado Número de llamadas para evitar múltiples triggers
     */
    public void verificarVictoria(int llamado) {
        if (this.creatures.isEmpty() && llamado == 1) {
            this.isPaused = true;
            LevelCompleted lc = new LevelCompleted(null, true);
            lc.setScore(String.valueOf(this.score));
            lc.setVisible(true);
            this.active = false;

            JFrame frame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor((java.awt.Component) drawable);
            if (frame != null) frame.dispose();
        }
    }

    /**
     * Detiene todos los hilos de monstruos activos usando ThreadGroup.
     */
    public void detenerHilosMonstruos() {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads, true);

        for (Thread thread : threads) {
            if (thread instanceof MonsterThread) {
                ((MonsterThread) thread).detener(); // ← Llama al nuevo método
            }
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
            posicion++;
        }
    }

    /**
     * Elimina una criatura del ArrayList creatures por índice.
     * @param index Índice de la criatura a eliminar.
     */
    public void eliminarCreature(int index){
        this.getCreatures().remove(index);
    }

    /**
     * Elimina una criatura del ArrayList creatures por referencia.
     * @param creature Instancia de LivingBeing a eliminar.
     */
    public void eliminarCreature(LivingBeing creature) {
        creatures.remove(creature);
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
    /**
     * Retorna el nombre del nivel actual.
     * @return El nombre del nivel.
     */
    public String getNivel() {
        return this.nivel;
    }

    /**
     * Retorna el tipo de caballero seleccionado.
     * @return El tipo de caballero.
     */
    public String getTipo() {
        return this.tipo;
    }
    /**
     * Cambia el estado activo del dungeon.
     * @param active true para activar, false para desactivar.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Asocia la instancia de Game a este dungeon.
     * @param game Instancia de Game.
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Indica si el juego está actualmente en pausa.
     * @return true si está en pausa, false en caso contrario.
     */
    public synchronized boolean isPaused() {
        return isPaused;
    }

    /**
     * Cambia el estado de pausa del juego.
     * @param estado true para pausar, false para reanudar.
     */
    public synchronized void setPaused(boolean estado) {
        isPaused = estado;
    }

}