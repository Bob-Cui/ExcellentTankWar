package cuibo.Mypackage.ChainOfRespnsibility;

import cuibo.Mypackage.AbstractObject;
import cuibo.Mypackage.Bullet;
import cuibo.Mypackage.EnemyTank;

/**
 * 子弹与坦克相撞
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(AbstractObject object1, AbstractObject object2) {
        if (object1 instanceof Bullet && object2 instanceof EnemyTank) {
            Bullet b = (Bullet) object1;
            EnemyTank r = (EnemyTank) object2;
            if (b.collideWithTank(r))
                return true;
            else return false;
        } else if (object1 instanceof EnemyTank && object2 instanceof Bullet)
            return collide(object2, object1);
       return false;

    }
}
