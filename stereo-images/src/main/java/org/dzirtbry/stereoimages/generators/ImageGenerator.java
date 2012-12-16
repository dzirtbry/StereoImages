package org.dzirtbry.stereoimages.generators;

import java.awt.image.BufferedImage;

/**
 * @author volodymyr.kotyuk
 */
public interface ImageGenerator {
    BufferedImage generate(int width, int height);
}
