package org.dzirtbry.stereoimages;

import org.dzirtbry.stereoimages.generators.GeometricImageGenerator;
import org.dzirtbry.stereoimages.generators.ImageGenerator;

import java.awt.image.BufferedImage;

/**
 * @author volodymyr.kotyuk
 */
public class StereoImageCreator {

    private final int fragmentSize;
    private final ImageGenerator generator;

    public StereoImageCreator() {
        this(new GeometricImageGenerator(), 80);
    }

    /**
     * Constructs Stereo Image generator with geometric font generator and fragment size equals to 80
     */
    public StereoImageCreator(int fragmentSize) {
        this(new GeometricImageGenerator(), fragmentSize);
    }

    public StereoImageCreator(ImageGenerator geometricImageGenerator, int fragmentSize) {
        this.fragmentSize = fragmentSize;
        generator = geometricImageGenerator;
    }

    private void populateBackground(BufferedImage image) {
        BufferedImage generate = generator.generate(fragmentSize, fragmentSize);
        for (int i = 0; i < Math.ceil(image.getWidth() * 1.0 / fragmentSize); i++) {
            for (int j = 0; j < Math.ceil(image.getHeight() * 1.0 / fragmentSize); j++) {
                image.getGraphics().drawImage(generate, i * generate.getWidth(),
                        j * generate.getHeight(), null);
            }
        }
    }

    private void applyStereo(BufferedImage image, int[][] mask) {
        int w = image.getWidth();
        int h = image.getHeight();

        int s = fragmentSize;
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++)
                if (mask[x][y] > 0) {
                    int pixel = image.getRGB(x + mask[x][y], y);
                    for (int i = x + s; i < w; i += s) {
                        image.setRGB(i, y, pixel);
                    }
                }
    }

    /**
     * Create stereo image via mask
     *
     * @param mask mask with
     * @return
     */
    public BufferedImage createStereoImage(int[][] mask) {
        if (mask.length < 1 && mask[0].length < 1) {
            throw new IllegalArgumentException("Mask mast be non-zero size");
        }

        BufferedImage image = new BufferedImage(mask.length, mask[0].length, BufferedImage.TYPE_INT_RGB);
        populateBackground(image);
        applyStereo(image, mask);

        return image;
    }

}
