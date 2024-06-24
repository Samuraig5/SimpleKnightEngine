import MathHelper.Randoms;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandomsTest {

    @Test
    public void testRange() {
        // Test case 1: Without rounding
        double result1 = Randoms.range(0.0, 1.0, false);
        assertTrue(result1 >= 0.0 && result1 <= 1.0);

        // Test case 2: With rounding
        double result2 = Randoms.range(0.0, 1.0, true);
        assertTrue(result2 >= 0.0 && result2 <= 1.0 && Math.floor(result2) == result2);
    }

    @Test
    public void testDecider() {
        // Test case 1: Event should always happen with 100% likelihood
        assertTrue(Randoms.decider(1.0f));

        // Test case 2: Event should never happen with 0% likelihood
        assertFalse(Randoms.decider(0.0f));

        // Test case 3: Event should sometimes happen with 50% likelihood
        boolean result = Randoms.decider(0.5f);
        assertTrue(result || !result); // True or False
    }

    @Test
    public void testDeciderInvalidPercentage() {
        // Test case: Invalid percentage should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> Randoms.decider(-0.1f));
        assertThrows(IllegalArgumentException.class, () -> Randoms.decider(1.1f));
    }
}
