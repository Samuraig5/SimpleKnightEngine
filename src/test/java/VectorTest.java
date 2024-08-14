import GameSpace.Vector.GridVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VectorTest
{
    @Test
    void test2DGridCoordinatesInitialization() {
        GridVector coords = GridVector.create(1, 2, 0);
        assertEquals(1, coords.x());
        assertEquals(2, coords.y());
        assertEquals(0, coords.z());

        Integer[] expected = {1, 2, 0};
        assertArrayEquals(expected, coords.toArray());
    }

    @Test
    void test3DGridCoordinatesInitialization() {
        GridVector coords = GridVector.create(1, 2, 3);
        assertEquals(1, coords.x());
        assertEquals(2, coords.y());
        assertEquals(3, coords.z());

        Integer[] expected = {1, 2, 3};
        assertArrayEquals(expected, coords.toArray());
    }

    @Test
    void test3DGridCoordinatesToRender() {
        //TODO: Implement Test
    }

    @Test
    void test3DFreeCoordinatesToRender() {
        //TODO: Implement Test
    }
}
