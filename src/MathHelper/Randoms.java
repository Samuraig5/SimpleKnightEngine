package MathHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Randoms
{
    private static final Logger logger = LoggerFactory.getLogger(Randoms.class);
    private static final Random random = new Random();

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


    /**
     * Determines the outcome of an event based on the given likelihood percentage.
     * <p>
     * A higher number is more likely: 0.0f means the event never happens, 1.0f means the event always happens.
     * </p>
     *
     * @param likelihoodPercentage a float between 0.0 and 1.0 representing the percentage chance of the event happening
     * @return {@code true} if the event happens based on the likelihood percentage, {@code false} otherwise
     * @throws IllegalArgumentException if {@code likelihoodPercentage} is not between 0.0 and 1.0
     */
    public static boolean decider(float likelihoodPercentage)
    {
        if (likelihoodPercentage < 0.0f || likelihoodPercentage > 1.0f) {
            logger.debug("Percentage must be between 0.0 and 1.0");
            throw new IllegalArgumentException("Percentage must be between 0.0 and 1.0");
        }
        return random.nextFloat() < likelihoodPercentage;
    }
}
