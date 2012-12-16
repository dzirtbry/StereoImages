package org.dzirtbry.stereoimages.generators;

import org.dzirtbry.stereoimages.MaskImageGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author volodymyr.kotyuk
 */
public class SimpleMaskCreator {

    private final int FRAGMENT_SIZE;

    public SimpleMaskCreator() {
        this(80);
    }

    public SimpleMaskCreator(int fragment_size) {
        FRAGMENT_SIZE = fragment_size;
    }

    public int[][] createMaskFromText(int width, int height, String s) {
        BufferedImage text = new TextImageGenerator(s).generate(width - FRAGMENT_SIZE, height - FRAGMENT_SIZE);

        int w = text.getWidth();
        int h = text.getHeight();
        int[][] mask = new int[width][height];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (Color.WHITE.getRGB() == text.getRGB(i, j)) {
                    mask[i][j] = 4;
                }
            }
        }
        return mask;
    }

    public int[][] createPackmanMask(int width, int height) {

        BufferedImage text = new MaskImageGenerator().generate(width - FRAGMENT_SIZE, height - FRAGMENT_SIZE);
        ((Graphics2D) text.getGraphics()).rotate(Math.PI / 4);
        int w = text.getWidth();
        int h = text.getHeight();
        int[][] mask = new int[width][height];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (Color.WHITE.getRGB() == text.getRGB(i, j)) {
                    mask[i][j] = 7;
                }
            }
        }
        return mask;
    }


    public int[][] createCrossMask(int width, int height) {
        int[][] mask = new int[width][height];

        int w4 = width / 4;
        int h4 = height / 4;

        for (int i = w4; i < width - 2 * w4; i++) {
            for (int j = h4; j < height - 2 * h4; j++) {
                mask[i][j] = 7;
            }
        }
        return mask;
    }
}
