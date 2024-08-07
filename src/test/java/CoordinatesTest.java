import Core.Settings;
import GameSpace.FreeCoordinates;
import GameSpace.GridCoordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinatesTest
{
    @Test
    void test2DGridCoordinatesInitialization() {
        GridCoordinates coords = new GridCoordinates(1, 2);
        assertEquals(1, coords.x());
        assertEquals(2, coords.y());
        assertEquals(0, coords.z());

        Integer[] expected = {1, 2, 0};
        assertArrayEquals(expected, coords.toArray());
    }

    @Test
    void test3DGridCoordinatesInitialization() {
        GridCoordinates coords = new GridCoordinates(1, 2, 3);
        assertEquals(1, coords.x());
        assertEquals(2, coords.y());
        assertEquals(3, coords.z());

        Integer[] expected = {1, 2, 3};
        assertArrayEquals(expected, coords.toArray());
    }

    @Test
    void test3DGridCoordinatesToRender() {
        GridCoordinates coords = new GridCoordinates(1, 2, 3);
        FreeCoordinates renderCoords = coords.getRenderCoordinates();

        assertEquals(1 * Settings.defaultGridSize, renderCoords.x());
        assertEquals(2 * Settings.defaultGridSize, renderCoords.y());
        assertEquals(3 * Settings.defaultGridSize, renderCoords.z());
    }

    @Test
    void test2DFreeCoordinatesInitialization() {
        FreeCoordinates coords = new FreeCoordinates(1.5, 2.5);
        assertEquals(1.5, coords.x());
        assertEquals(2.5, coords.y());
        assertEquals(0, coords.z());

        Double[] expected = {1.5, 2.5, 0d};
        assertArrayEquals(expected, coords.toArray());
    }

    @Test
    void test3DFreeCoordinatesInitialization() {
        FreeCoordinates coords = new FreeCoordinates(1.5, 2.5, 3.5);
        assertEquals(1.5, coords.x());
        assertEquals(2.5, coords.y());
        assertEquals(3.5, coords.z());

        Double[] expected = {1.5, 2.5, 3.5};
        assertArrayEquals(expected, coords.toArray());
    }

    @Test
    void test3DFreeCoordinatesToRender() {
        FreeCoordinates coords = new FreeCoordinates(1.5, 2.5, 3.5);
        FreeCoordinates renderCoords = coords.getRenderCoordinates();

        assertEquals(1.5, renderCoords.x());
        assertEquals(2.5, renderCoords.y());
        assertEquals(3.5, renderCoords.z());
    }
}
