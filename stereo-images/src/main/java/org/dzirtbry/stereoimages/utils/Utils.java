package org.dzirtbry.stereoimages.utils;

/**
 * @author volodymyr.kotyuk
 */
public class Utils {

    public static int getRandomInt(int high) {
        return getRandomInt(0, high);
    }

    public static int getRandomInt(int low, int high) {
        if (high < low) {
            throw new IllegalArgumentException();
        }
        int v = (int) (Math.random() * Math.abs(low - high));
        return v + low;
    }

}
