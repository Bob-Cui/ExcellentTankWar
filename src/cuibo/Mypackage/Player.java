package cuibo.Mypackage;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends AbstractObject{
    public static int SPEED = 5;       //常量必须使用全部大写的字母
    private int x, y;
    private Group belong = Group.GOOD;
    private Direction dir;

    private Boolean bU, bL, bD, bR;
    private Boolean moving = false;
    private boolean alive = true;

    public Player(int x, int y, Direction this_dir) {
        this.x = x;
        this.y = y;
        this.dir = this_dir;
        this.bL = false;
        this.bU = false;
        this.bD = false;
        this.bR = false;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //this function is by repaint method
    public void paint(Graphics g) {
        if (alive == false)
            return;
        switch (dir) {
            case UP:
                g.drawImage(ResourceManage.myTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManage.myTankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManage.myTankL, x, y, null);
                break;
            case Right:
                g.drawImage(ResourceManage.myTankR, x, y, null);
                break;
            default:
                break;
        }

        move();

    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    public void KeyPressed(KeyEvent e) {
        int Key = e.getKeyCode();
        switch (Key) {
            case KeyEvent.VK_LEFT:
                bL = true;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;
            case KeyEvent.VK_UP:
                bU = true;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                break;
        }
        setMoveDirection();
    }

    //竟然还能检查出我的拼写错误
    private void setMoveDirection() {
        if (!bU && !bR && !bL && !bD) {
            this.moving = false;
            return;
        }
        moving = true;

        if (bU && !bR && !bL && !bD) {
            this.dir = Direction.UP;
        } else if (!bU && bR && !bL && !bD)
            this.dir = Direction.Right;
        else if (!bU && !bR && bL && !bD) {
            this.dir = Direction.LEFT;
        } else if (!bU && !bR && !bL && bD)
            this.dir = Direction.DOWN;


    }


    private void move() {
        if (!moving)
            return;
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
    }

    public void KeyReleased(KeyEvent e) {

        int Key = e.getKeyCode();
        switch (Key) {
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
            case KeyEvent.VK_CONTROL:
                fire();
            default:
                break;
        }
        setMoveDirection();
    }

    private void fire() {
        int bX = x + ResourceManage.myTankU.getWidth() / 2 - ResourceManage.bulletU.getWidth() / 2;
        int bY = y + ResourceManage.myTankU.getWidth() / 2 - ResourceManage.bulletU.getWidth() / 2;
        Direction[] dirs = Direction.values();

        TankFrame.INSTANCE.getGameModel().addGameObjects(new Bullet(bX, bY, dir, belong));
    }

    public void die() {
        this.alive = false;
    }



    /**
     * 竟然能把类中的所有信息全打出来一遍
     * @return
     */
    @Override
    public String toString() {
        return "Player{" +
                "x=" + x +
                ", y=" + y +
                ", belong=" + belong +
                ", dir=" + dir +
                ", bU=" + bU +
                ", bL=" + bL +
                ", bD=" + bD +
                ", bR=" + bR +
                ", moving=" + moving +
                ", alive=" + alive +
                '}';
    }
}
