package cuibo.Mypackage;

import cuibo.Mypackage.ChainOfRespnsibility.CollideChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {


    public Player getMyTank() {
        return myTank;
    }

    private Player myTank;//不要需要对内部结构有了解就可以轻松的调用
    private CollideChain collideChain = new CollideChain();
    private static List<AbstractObject> gameObjects;


    public GameModel() {
        initGame();
    }


    private void initGame() {
        myTank = new Player(100, 100, Direction.Right);
        gameObjects = new ArrayList<>();
        addGameObjects(new Wall(100, 100, 30, 30));
        int initTankCount = PropertyManage.getNumber("initTankCount");
        for (int i = 0; i < initTankCount; i++) {
            gameObjects.add(new EnemyTank(100 + 70 * i, 200, Direction.UP));
        }

    }


    public void addGameObjects(AbstractObject object) {

        gameObjects.add(object);


    }


    public void paint(Graphics g) {
        myTank.paint(g);
        for (int i = 0; i < gameObjects.size(); i++) {
            if (!gameObjects.get(i).isAlive())
                gameObjects.remove(i);

        }

        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
            for (int j = 1; j < gameObjects.size(); j++) {
                AbstractObject a = gameObjects.get(i);
                AbstractObject b = gameObjects.get(j);
                collideChain.collide(a, b);
            }
        }


    }
}
