package cuibo.Mypackage;

import java.util.Random;

public enum Direction {//可以使的bug尽早出现,相应的变量只能取四个值
    DOWN, LEFT, Right, UP, STOP;
    private static Random r = new Random();


    /*
    静态成员只能通过静态的方法或函数调用
    接口内部也能定义函数
    */
    public static Direction getRandomDir() {
        return Direction.values()[r.nextInt(Direction.values().length)];
    }

}
