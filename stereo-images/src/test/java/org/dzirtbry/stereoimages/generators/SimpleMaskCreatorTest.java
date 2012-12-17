package org.dzirtbry.stereoimages.generators;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author volodymyr.kotyuk
 */
public class SimpleMaskCreatorTest {

    private SimpleMaskCreator simpleMaskCreator;

    @Before
    public void setUp() throws Exception {
        simpleMaskCreator = new SimpleMaskCreator();
    }

    @Test
    public void testGeneratedTextMaskSize() throws Exception {
        int[][] testTexts = simpleMaskCreator.createMaskFromText(100, 100, "TestText");

        assertEquals(testTexts.length, 100);
        assertEquals(testTexts[0].length, 100);
    }

    @Test
    public void testGeneratedCrossMaskSize() throws Exception {
        int[][] testTexts = simpleMaskCreator.createCrossMask(100, 100);

        assertEquals(testTexts.length, 100);
        assertEquals(testTexts[0].length, 100);
    }

    @Test
    public void testGeneratedPackmanMaskSize() throws Exception {
        int[][] testTexts = simpleMaskCreator.createPackmanMask(100, 100);

        assertEquals(testTexts.length, 100);
        assertEquals(testTexts[0].length, 100);
    }
}
