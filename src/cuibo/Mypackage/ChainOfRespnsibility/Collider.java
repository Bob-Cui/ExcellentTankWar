package cuibo.Mypackage.ChainOfRespnsibility;

import cuibo.Mypackage.AbstractObject;

import java.io.Serializable;

/**
 * 这个继承有问题
 */
public interface Collider  extends Serializable
{
    /**
     * 用来处理两件物体的碰撞，果然是有趣的
     * @param object1
     * @param object2
     */

    public boolean collide(AbstractObject object1, AbstractObject object2);
}

