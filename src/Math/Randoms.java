package src.Math;

public class Randoms
{
    /**
     * Returns a value within the provided min and max.
     * @param min min value (inclusive)
     * @param max max value (inclusive)
     * @param roundResult should the result be rounded down to an integer
     * @return double, rounded or not.
     * @param <T> A number
     */
    public static <T extends Number> double range(T min, T max, boolean roundResult)
    {
        if (roundResult) { //Rounded down case requires a +1 so the max is inclusive
            return Math.floor(min.doubleValue() + (Math.random() * (max.doubleValue() - min.doubleValue() + 1)));
        }
        return min.doubleValue() + (Math.random() * (max.doubleValue() - min.doubleValue()));
    }
}
