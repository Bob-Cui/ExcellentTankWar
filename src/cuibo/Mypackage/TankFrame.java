package cuibo.Mypackage;

import cuibo.Mypackage.ChainOfRespnsibility.CollideChain;
import cuibo.Mypackage.ChainOfRespnsibility.Collider;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    public static final TankFrame INSTANCE = new TankFrame();
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    public GameModel getGameModel() {
        return gameModel;
    }

    private GameModel gameModel = new GameModel();

//    private Player myTank;//不要需要对内部结构有了解就可以轻松的调用
//    private CollideChain collideChain = new CollideChain();
//    private List<AbstractObject> gameObjects;


    private TankFrame() {
        this.setTitle("坦克大战");
        this.setLocation(400, 100);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.addKeyListener(new TankKeyListener());

        //  initCollider();
        initGame();
    }

    /**
     * 这里我们使用了项目内部的配置文件，这真是一种有趣的方法
     * 配置文件中可以写入很多的参数
     */
    private void initGame() {

    }


    @Override

    /* 这个东西是自动调用的 */
    public void paint(Graphics g) {
        gameModel.paint(g);
    }

//    public void addGameObjects(AbstractObject abstractObject) {
//
//        gameModel.addGameObjects(abstractObject);
//    }


    //不需要被外人知道
    private class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            gameModel.getMyTank().KeyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            gameModel.getMyTank().KeyReleased(e);
        }

    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        /*双缓冲技术解决屏闪问题*/
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffscreen = offScreenImage.getGraphics();
        Color c = gOffscreen.getColor();
        gOffscreen.setColor(Color.BLACK);
        gOffscreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffscreen.setColor(c);
        paint(gOffscreen);
        g.drawImage(offScreenImage, 0, 0, null);

    }
}