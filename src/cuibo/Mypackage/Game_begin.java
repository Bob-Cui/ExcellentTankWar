package cuibo.Mypackage;

public class Game_begin {

    public static void main(String[] args) {
        TankFrame tank = TankFrame.INSTANCE;
        tank.setVisible(true);
/**
 * 一秒钟刷新四十次
 */
        while (true) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tank.repaint();//似乎解决了更新的问题
        }


    }
}
