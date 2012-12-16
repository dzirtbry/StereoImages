package org.dzirtbry.stereoimages.generators;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author volodymyr.kotyuk
 */
public class TextImageGenerator implements ImageGenerator {

    String s;

    public TextImageGenerator(String s) {
        this.s = s;
    }

    @Override
    public BufferedImage generate(int width, int height) {
        BufferedImage text = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        final Graphics graphics = text.getGraphics();
        int fontSize = 12;
        Font monospaced = new Font("Monospaced", Font.BOLD, fontSize);
        while (graphics.getFontMetrics(monospaced).stringWidth(s) < width) {
            fontSize += 10;
            monospaced = new Font("Monospaced", Font.BOLD, fontSize);
        }
        fontSize -= 10;
        monospaced = new Font("Monospaced", Font.BOLD, fontSize);
        graphics.setFont(monospaced);
        graphics.setColor(Color.WHITE);
        graphics.drawString(s, 10, height / 2);
        text.flush();
        return text;
    }
}
