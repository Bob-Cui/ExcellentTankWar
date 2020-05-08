package cuibo.Mypackage;


import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManage {
    public static BufferedImage myTankU, myTankD, myTankL, myTankR;
    public static BufferedImage enTankU, enTankD, enTankL, enTankR;
    public static BufferedImage bulletU, bulletD, bulletL, bulletR;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {/*听说好像是顺时针*/
        try {//不能写这种换一个地址就找不到文件的的代码
            myTankU = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            myTankL = MyImageUtil.rotateimage(myTankU, -90);
            myTankD = MyImageUtil.rotateimage(myTankU, 180);
            myTankR = MyImageUtil.rotateimage(myTankU, 90);


            enTankU = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            enTankL = MyImageUtil.rotateimage(enTankU, -90);
            enTankD = MyImageUtil.rotateimage(enTankU, 180);
            enTankR = MyImageUtil.rotateimage(enTankU, 90);

            bulletU = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL = MyImageUtil.rotateimage(bulletU, -90);
            bulletD = MyImageUtil.rotateimage(bulletU, 180);
            bulletR = MyImageUtil.rotateimage(bulletU, 90);
            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(ResourceManage.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
