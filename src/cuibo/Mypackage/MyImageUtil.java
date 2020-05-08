package cuibo.Mypackage;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 用来将原有的图片进行翻转
 */
public class MyImageUtil {
    public static BufferedImage rotateimage(final BufferedImage input, final int degree) {
        int w = input.getWidth();
        int h = input.getHeight();
        int type = input.getColorModel().getTransparency();
        BufferedImage output;
        Graphics2D graphics2D;


        (graphics2D = (output = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2D.drawImage(input, 0, 0, null);
        graphics2D.dispose();
        return output;

    }

}
