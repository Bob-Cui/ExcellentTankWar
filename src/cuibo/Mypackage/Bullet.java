package cuibo.Mypackage;

import java.awt.*;

public class Bullet extends AbstractObject {
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private Direction dir;
    private static int SPEED = 30;
    private Group group;
    private boolean aLive = true;

    public Bullet(int x, int y, Direction dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!aLive) return;
        switch (dir) {
            case UP:
                g.drawImage(ResourceManage.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManage.bulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManage.bulletL, x, y, null);
                break;
            case Right:
                g.drawImage(ResourceManage.bulletR, x, y, null);
                break;
            default:
                break;
        }

        move();
    }

    /**
     * 子弹与坦克碰撞的函数
     *
     * @param fuckTank
     */
    public boolean collideWithTank(EnemyTank fuckTank) {
        if (!aLive || !fuckTank.isAlive()) return false;
        if (this.group == fuckTank.getGroup()) return false;
        Rectangle rectBullet = new Rectangle(x, y, ResourceManage.bulletU.getWidth(), ResourceManage.bulletU.getHeight());
        Rectangle rectTank = new Rectangle(fuckTank.getX(), fuckTank.getY(), ResourceManage.myTankU.getWidth(), ResourceManage.myTankU.getHeight());

        if (rectBullet.intersects(rectTank)) {
            fuckTank.die();
            this.die();
            return true;
        }
        return false;
    }

    public void die() {
        if (aLive == true)
            aLive = false;
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case Right:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case STOP:
                break;
        }
        inBound();
    }


    public boolean inBound() {
        boolean b = aLive = ((x >= 0) && (x <= TankFrame.INSTANCE.GAME_WIDTH) && (y >= 0) && (y <= TankFrame.INSTANCE.GAME_HEIGHT));
        return b;

    }

    public boolean isAlive() {
        return aLive;
    }


    public int getWidth() {
        if (dir == Direction.UP || dir == Direction.DOWN)
            return ResourceManage.bulletU.getWidth();
        else {
            return ResourceManage.bulletU.getHeight();
        }
    }

    public int getHeight() {
        if (dir == Direction.UP || dir == Direction.DOWN)
            return ResourceManage.bulletU.getHeight();
        else {
            return ResourceManage.bulletU.getWidth();
        }
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "x=" + x +
                ", y=" + y +
                ", dir=" + dir +
                ", group=" + group +
                ", aLive=" + aLive +
                '}';
    }
}