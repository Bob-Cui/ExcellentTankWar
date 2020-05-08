package cuibo.Mypackage;

import java.awt.*;

/**
 * 要谨慎地选择基类，尽可能的向基类中加入少的属性
 */
public abstract class  AbstractObject {
    /**
     * 抽象类中的抽象函数不应该有函数体出现
     * @param g
     */
    public abstract void paint(Graphics g);
    public abstract boolean isAlive();
}
