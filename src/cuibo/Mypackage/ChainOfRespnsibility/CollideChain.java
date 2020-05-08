package cuibo.Mypackage.ChainOfRespnsibility;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import cuibo.Mypackage.AbstractObject;
import cuibo.Mypackage.PropertyManage;

import java.util.ArrayList;
import java.util.List;

public class CollideChain implements Collider {


    private List<Collider> colliders=new ArrayList<>();

    public CollideChain() {
        initcollliders();
    }

    /**
     * 进行初始化
     */
    private void initcollliders() {
        colliders = new ArrayList<>();
        String[] colliderNames = PropertyManage.get("colliders").split(",");

        for (String name : colliderNames) {

            try {
                Class clazz = Class.forName("cuibo.Mypackage.ChainOfRespnsibility." + name);
                Collider t = (Collider) clazz.getConstructor().newInstance();
                colliders.add(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public boolean collide(AbstractObject object1, AbstractObject object2) {

        for (Collider collider : colliders)
            if (collider.collide(object1, object2)) {
                return true;
            }
        return false;
    }
}
