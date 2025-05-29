package Class;

import java.awt.Color;

public abstract class SpriteMobile extends Sprite {
    protected int velocidadX = 0;
    protected int velocidadY = 0;

    public SpriteMobile(int x, int y,int height, Color color, int width) {
        super(x, y,height,width,color);
    }

    public void mover() {
        this.x += velocidadX;
        this.y += velocidadY;
    }

    public void setVelocidad(int vx, int vy) {
        this.velocidadX = vx;
        this.velocidadY = vy;
    }
}