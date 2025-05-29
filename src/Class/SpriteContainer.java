package Class;

import java.util.ArrayList;
import java.util.List;
import Class.Sprite;
import Class.SpriteMobile;

public class SpriteContainer {
    private List<Sprite> sprites = new ArrayList<>();

    public void agregar(Sprite s) {
        sprites.add(s);
    }

    public void eliminar(Sprite s) {
        sprites.remove(s);
    }

    public List<Sprite> getTodos() {
        return sprites;
    }

    public void actualizar() {
        for (Sprite s : sprites) {
            if (s instanceof SpriteMobile) {
                ((SpriteMobile) s).mover();
            }
        }
    }
}