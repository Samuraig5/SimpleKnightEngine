import GameSpace.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinatesTest
{
    @Test
    void test2DCoordinatesInitialization() {
        Coordinates<Integer> coords = new Coordinates<>(1, 2);
        assertEquals(1, coords.x());
        assertEquals(2, coords.y());
        assertEquals(0, coords.z());

        Integer[] expected = {1, 2, 0};
        assertArrayEquals(expected, coords.toArray());
    }

    @Test
    void test3DCoordinatesInitialization() {
        Coordinates<Double> coords = new Coordinates<>(1.5, 2.5, 3.5);
        assertEquals(1.5, coords.x());
        assertEquals(2.5, coords.y());
        assertEquals(3.5, coords.z());

        Double[] expected = {1.5, 2.5, 3.5};
        assertArrayEquals(expected, coords.toArray());
    }
}
