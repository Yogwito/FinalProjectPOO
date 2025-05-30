/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dungeons.gui;

import Class.Dungeon;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * Panel personalizado para mostrar el dungeon del juego.
 * Hereda de JPanel e implementa la interfaz Drawable para permitir el redibujado del mapa.
 * Utiliza una instancia de Dungeon para delegar el dibujo del escenario y sus elementos.
 *
 * @author Juan Sebastian Arias
 * @author Juan Jose Trujillo
 * @author Juan Jose Cardona
 * @version 1.0.2
 */
public class DungeonPanel extends JPanel implements Drawable {
    /**
     * Instancia del dungeon que se va a mostrar en el panel.
     */
    private Dungeon dungeon;

    /**
     * Constructor de DungeonPanel.
     * @param dungeon El dungeon que se va a mostrar en el panel.
     */
    public DungeonPanel(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    /**
     * Dibuja el contenido del dungeon en el panel.
     * @param g El contexto gráfico donde se dibuja.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (dungeon != null) {
            dungeon.draw(g); 
        }
    }

    /**
     * Redibuja el panel llamando a repaint().
     */
    @Override
    public void redraw() {
        repaint();
    }
}