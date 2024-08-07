import MathHelper.Basics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BasicsTest {
    @Test
    public void testClampInteger() {
        Assertions.assertEquals(5, Basics.clamp(5, 0, 10));
        assertEquals(0, Basics.clamp(-5, 0, 10));
        assertEquals(10, Basics.clamp(15, 0, 10));
    }

    @Test
    public void testClampDouble() {
        assertEquals(5.5, Basics.clamp(5.5, 0.0, 10.0));
        assertEquals(0.0, Basics.clamp(-5.0, 0.0, 10.0));
        assertEquals(10.0, Basics.clamp(15.0, 0.0, 10.0));
    }

    @Test
    public void testIndexToLetter() {
        assertEquals("a", Basics.indexToLetter(0));
        assertEquals("z", Basics.indexToLetter(25));
        assertEquals("f", Basics.indexToLetter(5));
        assertEquals("Invalid index", Basics.indexToLetter(26));
        assertEquals("Invalid index", Basics.indexToLetter(-1));
    }

    @Test
    public void testLetterToIndex() {
        assertEquals(0, Basics.letterToIndex('a'));
        assertEquals(25, Basics.letterToIndex('z'));
        assertEquals(5, Basics.letterToIndex('f'));
        assertEquals(-1, Basics.letterToIndex('A')); // Not lowercase
        assertEquals(-1, Basics.letterToIndex('1')); // Not a letter
    }
}
