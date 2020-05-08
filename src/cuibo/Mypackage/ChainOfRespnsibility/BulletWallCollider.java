package cuibo.Mypackage.ChainOfRespnsibility;

import cuibo.Mypackage.*;

import java.awt.*;

public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(AbstractObject object1, AbstractObject object2) {
        if (object1 instanceof Bullet && object2 instanceof Wall) {
            Bullet bullet = (Bullet) object1;
            Wall wall = (Wall) object2;
            if (!bullet.isAlive()) return false;
            else {
                Rectangle recBullet = new Rectangle(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight());
                Rectangle recwall = new Rectangle(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
                if (recBullet.intersects(recwall)) {
                    bullet.die();
                    TankFrame.INSTANCE.getGameModel().addGameObjects(new Explode(wall.getX(), wall.getY()));

                    System.out.println(bullet);
                    return true;
                }
                return false;
            }


        } else if (object1 instanceof Wall && object2 instanceof Bullet)
            return collide(object2, object1);

        return false;
    }
}
