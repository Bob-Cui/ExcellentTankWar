package cuibo.Mypackage.Strategy;

import cuibo.Mypackage.*;

/**
 * 为什么类继承接口会出现重载这种东西
 * 似乎是对多态的一种实现
 */
public class DefaultFireStrategy implements  FireStrategy {

    @Override
    public void fire(EnemyTank Tank) {
        int bX = Tank.getX() + ResourceManage.myTankU.getWidth() / 2 - ResourceManage.bulletU.getWidth() / 2;
        int bY = Tank.getY() + ResourceManage.myTankU.getWidth() / 2 - ResourceManage.bulletU.getWidth() / 2;


        TankFrame.INSTANCE.getGameModel().addGameObjects(new Bullet(bX, bY, Tank.getDirection(), Tank.getGroup()));

    }
}
