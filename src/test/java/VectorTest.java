import Core.Settings;
import GameSpace.Vector.FreeVector;
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
        GridVector coords = GridVector.create(1, 2, 3);
        FreeVector renderCoords = coords.getRenderCoordinates(1);

        assertEquals(1 * Settings.defaultGridSize, renderCoords.x());
        assertEquals(2 * Settings.defaultGridSize, renderCoords.y());
        assertEquals(3 * Settings.defaultGridSize, renderCoords.z());
    }

    @Test
    void test2DFreeCoordinatesInitialization() {
        FreeVector coords = FreeVector.create(1.5, 2.5, 0);
        assertEquals(1.5, coords.x());
        assertEquals(2.5, coords.y());
        assertEquals(0, coords.z());

        Double[] expected = {1.5, 2.5, 0d};
        assertArrayEquals(expected, coords.toArray());
    }

    @Test
    void test3DFreeCoordinatesInitialization() {
        FreeVector coords = FreeVector.create(1.5, 2.5, 3.5);
        assertEquals(1.5, coords.x());
        assertEquals(2.5, coords.y());
        assertEquals(3.5, coords.z());

        Double[] expected = {1.5, 2.5, 3.5};
        assertArrayEquals(expected, coords.toArray());
    }

    @Test
    void test3DFreeCoordinatesToRender() {
        FreeVector coords = FreeVector.create(1.5, 2.5, 3.5);
        FreeVector renderCoords = coords.getRenderCoordinates(1);

        assertEquals(1.5, renderCoords.x());
        assertEquals(2.5, renderCoords.y());
        assertEquals(3.5, renderCoords.z());
    }
}
