package org.dzirtbry.stereoimages;

import org.dzirtbry.stereoimages.generators.ImageGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Generates packman mask
 *
 * @author dzirtbry
 */
public class MaskImageGenerator implements ImageGenerator {

    @Override
    public BufferedImage generate(int width, int height) {
        BufferedImage text = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        final Graphics graphics = text.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillArc(width / 4, height / 4, width / 4, height / 4, 45, 275);
        text.flush();
        return text;
    }
}
