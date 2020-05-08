package cuibo.Mypackage;

import java.awt.*;

public class Wall extends AbstractObject {

    private int x, y, width, height;

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isAlive() {
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void paint(Graphics g) {

        //Rectangle rec=new Rectangle(x,y,width,height);

        g.setColor(Color.red);

        // 采用fill的方法可以画满一面墙
        g.fillRect(x, y, width, height);
    }

    @Override
    public String toString() {
        return "Wall{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
