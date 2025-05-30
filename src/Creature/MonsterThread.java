
package Creature;

import Class.Dungeon;
import Class.LivingBeing;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Esta es una clase MonsterThread que hereda de la clase Thread.
 * Se utiliza para manejar el movimiento y el ataque de un monstruo en un hilo separado.
 * @author Juan José Trujillo
 * @author Juan Sebastian Arias
 * @author Juan José Cardona
 * @version 1.0.2
 */
public class MonsterThread extends Thread {

    /**
     * El calabozo en el que se encuentra el monstruo.
     */
    private final Dungeon dungeon;

    /**
     * El monstruo que este hilo está manejando.
     */
    private final Monster monster;
    
    private ScheduledExecutorService scheduler;
    
    private volatile boolean enEjecucion = true;


    /**
     * Constructor de la clase MonsterThread.
     * Inicializa las propiedades de la clase con los valores proporcionados.
     * @param dungeon El calabozo en el que se encuentra el monstruo.
     * @param monster El monstruo que este hilo está manejando.
     */
    
    public MonsterThread(Dungeon dungeon, Monster monster) {
        this.dungeon = dungeon;
        this.monster = monster;
    }

    /**
     * El método que se ejecuta cuando se inicia el hilo.
     * Mueve al monstruo, verifica si el monstruo colisiona con el caballero y, en caso afirmativo, hace que el monstruo ataque.
     * Luego, redibuja el calabozo.
     */
    @Override
    public void run() {
        scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            if (!enEjecucion || dungeon.isPaused()) return;

            monster.moveCreature(dungeon, dungeon.getMuros(), dungeon.getCreatures(), dungeon.getArthur());

            if (monster instanceof Dragon) {
                monster.attack();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (monster.checkCollision(dungeon.getArthur())) {
                monster.attack();
            }

            dungeon.getDrawable().redraw();
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void detener() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdownNow(); // <- Detiene el hilo
        }
    }

    /**
     * Obtiene el monstruo que este hilo está manejando.
     * @return the monster
     */
    public Monster getMonster() {
        return monster;
    }


}
