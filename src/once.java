import cuibo.Mypackage.ResourceManage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class once {

    public static void main(String[] args) {
        BufferedImage myTankU;
        try {
            myTankU = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
