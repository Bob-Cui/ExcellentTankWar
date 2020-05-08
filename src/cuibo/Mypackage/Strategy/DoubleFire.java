package cuibo.Mypackage.Strategy;

import cuibo.Mypackage.*;

public class DoubleFire implements FireStrategy {

    @Override
    public void fire(EnemyTank Tank) {
        int bX = Tank.getX() + ResourceManage.myTankU.getWidth() / 2 - ResourceManage.bulletU.getWidth() / 2;
        int bY = Tank.getY() + ResourceManage.myTankU.getWidth() / 2 - ResourceManage.bulletU.getWidth() / 2;

        TankFrame.INSTANCE.getGameModel().addGameObjects(new Bullet(bX, bY, Direction.UP, Tank.getGroup()));
        TankFrame.INSTANCE.getGameModel().addGameObjects(new Bullet(bX, bY,Direction.DOWN , Tank.getGroup()));
    }
}
