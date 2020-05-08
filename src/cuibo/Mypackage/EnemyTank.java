package cuibo.Mypackage;

import cuibo.Mypackage.Strategy.FireStrategy;
import cuibo.Mypackage.Strategy.DoubleFire;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class EnemyTank  extends AbstractObject{
    public static int SPEED = 5;       //常量必须使用全部大写的字母
    private int x, y;
    private Group group = Group.ENEMY;
    private Direction dir;

    public Group getGroup() {
        return group;
    }

    private Boolean bU, bL, bD, bR;
    private Boolean moving = true;
    private boolean alive = true;


    public EnemyTank(int x, int y, Direction this_dir) {
        this.x = x;
        this.y = y;
        this.dir = this_dir;

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
                g.drawImage(ResourceManage.enTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManage.enTankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManage.enTankL, x, y, null);
                break;
            case Right:
                g.drawImage(ResourceManage.enTankR, x, y, null);
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
            moving = false;
            return;
        }
        moving = true;

        if (bU && !bR && !bL && !bD) {
            dir = Direction.UP;
        } else if (!bU && bR && !bL && !bD)
            dir = Direction.Right;
        else if (!bU && !bR && bL && !bD)
            dir = Direction.LEFT;
        else if (!bU && !bR && !bL && bD)
            dir = Direction.DOWN;


    }


    private void move() {
        if (moving == false)
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

        randomDirection();
        inBound();
        if (r.nextInt(100) < 5)
            fire();
    }

    private Random r = new Random();

    /* 根深蒂固的面向对象的思想 */
    private void randomDirection() {
        if (r.nextInt(100) > 95)
            this.dir = Direction.getRandomDir();
    }


    private void fire() {
        ClassLoader loader = EnemyTank.class.getClassLoader();
        FireStrategy strategy = null;
        String className = PropertyManage.get("tankFireStrategy");
        try {
            Class clazz = Class.forName("cuibo.Mypackage.Strategy." + className);
            strategy = (FireStrategy) (clazz.getDeclaredConstructor().newInstance());

        } catch (Exception e) {
            e.printStackTrace();
        }

        strategy.fire(this);
//

    }

    public void die() {
        this.alive = false;
        TankFrame.INSTANCE.getGameModel().addGameObjects(new Explode(this.x, this.y));

    }



    public void turnAround() {

        switch (dir) {
            case LEFT:
                dir = Direction.Right;
                break;
            case Right:
                dir = Direction.LEFT;
                break;
            case UP:
                dir = Direction.DOWN;
                break;
            case DOWN:
                dir = Direction.UP;
                break;
            case STOP:
                break;
        }
    }


    private void inBound() {

        int temp = ((ResourceManage.myTankU.getWidth() > ResourceManage.myTankU.getHeight()) ?
                ResourceManage.myTankU.getWidth() :
                ResourceManage.myTankU.getHeight());
        boolean b = (((x - temp) >= 0) && ((x + temp) <= TankFrame.INSTANCE.GAME_WIDTH) && ((y - temp) >= 0) && ((y + temp) <= TankFrame.INSTANCE.GAME_HEIGHT));
        if (b == false) {
            turnAround();
        }
    }

    public Direction getDirection() {
        return dir;
    }
}
