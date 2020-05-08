package cuibo.Mypackage;

import java.awt.*;

public class Explode extends AbstractObject{

    public int x, y;
    public int width, height;
    private int step;
    private boolean alive;

    public boolean isAlive() {
        return alive;
    }

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        this.step = 0;
        this.alive = true;
        this.width = ResourceManage.explodes[1].getWidth();
        this.height = ResourceManage.explodes[1].getHeight();
    }

    /**
     * 每次只能画一帧
     *这同样是一种多态
     * @param g
     */
    public void paint(Graphics g) {
        if (alive) {
            g.drawImage(ResourceManage.explodes[step], x, y, null);
            step++;
            if (step == 16)
                this.alive = false;
        }
    }


}
