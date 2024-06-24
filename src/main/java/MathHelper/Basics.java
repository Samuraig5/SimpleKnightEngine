package MathHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Basics
{
    private static final Logger logger = LoggerFactory.getLogger(Basics.class);

    /**
     * Hard clamps the value between min and mix.
     * @param value value to be clamped
     * @param min lower bound
     * @param max upper bound
     * @return clamped value
     * @param <T> any comparable datatype
     */
    public static <T extends Comparable<T>> T clamp(T value, T min, T max)
    {
        if (value.compareTo(min) < 0) {
            return min;
        } else if (value.compareTo(max) > 0) {
            return max;
        } else {
            return value;
        }
    }

    /**
     * Converts an index to its corresponding lowercase letter.
     * The index should be between 0 and 25 inclusive.
     *
     * @param n the index (0 for 'a', 1 for 'b', ..., 25 for 'z')
     * @return the corresponding lowercase letter, or "Invalid index" if the index is out of range
     */
    public static String indexToLetter(int n) {
        if (n < 0 || n > 25) {
            logger.debug("invalid index");
            return "Invalid index";
        }
        return String.valueOf((char) ('a' + n));
    }

    /**
     * Converts a lowercase letter to its corresponding index.
     * The letter should be between 'a' and 'z' inclusive.
     *
     * @param letter the lowercase letter ('a' for 0, 'b' for 1, ..., 'z' for 25)
     * @return the corresponding index, or -1 if the letter is out of range
     */
    public static int letterToIndex(char letter) {
        if (letter < 'a' || letter > 'z') {
            logger.debug("invalid letter");
            return -1;
        }
        return letter - 'a';
    }
}
