package org.dzirtbry.stereoimages.generators;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.dzirtbry.stereoimages.utils.Utils.getRandomInt;

/**
 * Image generator based on random pixel colors
 *
 * @author volodymyr.kotyuk
 */
public class SimpleImageGenerator implements ImageGenerator {

    public BufferedImage generate(int w, int h) {
        BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                Color color = new Color(getRandomInt(256), getRandomInt(256), getRandomInt(256));
                bufferedImage.setRGB(i, j, color.getRGB());
            }
        }
        return bufferedImage;
    }
}
