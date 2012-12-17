package org.dzirtbry.stereoimages.generators;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import static org.dzirtbry.stereoimages.utils.Utils.getRandomInt;

/**
 * Generates random images, based on different shapes
 *
 * @author volodymyr.kotyuk
 */
public class GeometricImageGenerator implements ImageGenerator {
    private int dividor = 6;
    private int repetitions = 3000;

    @Override
    public BufferedImage generate(int w, int h) {
        BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int[] v = new int[5];
        for (int i = 0; i < repetitions; i++) {
            final int t = (int) (Math.random() * 5);
            v[t]++;
            switch (t) {
                case 0:
                    drawRandomOval(bufferedImage);
                    break;
                case 1:
                    drawRandomRect(bufferedImage);
                    break;
                case 2:
                    drawRandom3DRect(bufferedImage);
                    break;
                case 3:
                    drawRandomArc(bufferedImage);
                    break;
                case 4:
                    drawRandomLine(bufferedImage);
                    break;
            }
        }
        return bufferedImage;
    }

    private void drawRandomLine(BufferedImage bufferedImage) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        Graphics graphics = bufferedImage.getGraphics();
        final Color color = graphics.getColor();

        Color c = new Color(getRandomInt(256), getRandomInt(256), getRandomInt(256));

        graphics.setColor(c);
        final int x = getRandomInt(w);
        final int y = getRandomInt(h);
        graphics.drawLine(x, y, x + getRandomInt(-w / dividor, w / dividor), h + getRandomInt(-h / dividor, h / dividor));

        bufferedImage.flush();

        graphics.setColor(color);
    }

    private void drawRandomArc(BufferedImage bufferedImage) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        Graphics graphics = bufferedImage.getGraphics();
        final Color color = graphics.getColor();

        Color c = new Color(getRandomInt(256), getRandomInt(256), getRandomInt(256));

        graphics.setColor(c);
        graphics.fillArc(getRandomInt(-w, w), getRandomInt(-h, h), getRandomInt(w / dividor), getRandomInt(h / dividor), getRandomInt(360), getRandomInt(360));

        bufferedImage.flush();

        graphics.setColor(color);
    }

    private void drawRandom3DRect(BufferedImage bufferedImage) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        Graphics graphics = bufferedImage.getGraphics();
        final Color color = graphics.getColor();

        Color c = new Color(getRandomInt(256), getRandomInt(256), getRandomInt(256));

        graphics.setColor(c);
        graphics.fill3DRect(getRandomInt(-w, w), getRandomInt(-h, h), getRandomInt(w / dividor), getRandomInt(h / dividor), true);

        bufferedImage.flush();

        graphics.setColor(color);
    }


    private void drawRandomOval(BufferedImage bufferedImage) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        Graphics graphics = bufferedImage.getGraphics();
        final Color color = graphics.getColor();

        Color c = new Color(getRandomInt(256), getRandomInt(256), getRandomInt(256));

        graphics.setColor(c);
        graphics.fillOval(getRandomInt(-w, w), getRandomInt(-h, h), getRandomInt(w / dividor), getRandomInt(h / dividor));

        bufferedImage.flush();

        graphics.setColor(color);
    }

    private void drawRandomRect(BufferedImage bufferedImage) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        Graphics graphics = bufferedImage.getGraphics();
        final Color color = graphics.getColor();

        Color c = new Color(getRandomInt(256), getRandomInt(256), getRandomInt(256));

        graphics.setColor(c);
        graphics.fillRect(getRandomInt(-w, w), getRandomInt(-h, h), getRandomInt(w / dividor), getRandomInt(h / dividor));

        bufferedImage.flush();

        graphics.setColor(color);
    }

    public int getDividor() {
        return dividor;
    }

    public void setDividor(int dividor) {
        this.dividor = dividor;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }
}
