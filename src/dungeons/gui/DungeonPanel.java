package dungeons.gui;

import Class.Dungeon;
import javax.swing.JPanel;
import java.awt.Graphics;

public class DungeonPanel extends JPanel implements Drawable {
    private Dungeon dungeon;

    public DungeonPanel(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (dungeon != null) {
            dungeon.draw(g); 
        }
    }
        @Override
    public void redraw() {
        repaint();
    }
}