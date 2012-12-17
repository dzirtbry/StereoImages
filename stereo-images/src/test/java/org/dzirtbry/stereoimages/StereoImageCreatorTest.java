package org.dzirtbry.stereoimages;

import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static junit.framework.Assert.assertEquals;

/**
 * @author volodymyr.kotyuk
 */
public class StereoImageCreatorTest {
    private StereoImageCreator imageCreator;

    @Before
    public void setUp() throws Exception {
        imageCreator = new StereoImageCreator();

    }

    @Test
    public void testCreateStereoImageSize() throws Exception {
        int[][] mask = new int[10][10];

        BufferedImage stereoImage = imageCreator.createStereoImage(mask);

        assertEquals(10, stereoImage.getHeight());
        assertEquals(10, stereoImage.getWidth());
    }
}
