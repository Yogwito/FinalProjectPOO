package graphics;

import java.awt.Graphics;
import java.util.List;
import Class.Sprite;

public class GraphicContainer {
    private List<Sprite> sprites;

    public GraphicContainer(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    public void setSprites(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    public void draw(Graphics g) {
        for (Sprite s : sprites) {
            s.draw(g);
        }
    }
}