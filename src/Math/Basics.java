package src.Math;

public class Basics
{
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
}
