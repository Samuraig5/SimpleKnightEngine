import GameSpace.FreeCoordinates;
import GameSpace.GridCoordinates;
import GameSpace.GridSpace;
import MathHelper.Randoms;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridSpaceTest
{
    @Test
    void testGridSpaceInitialization2D() {
        GridCoordinates size = new GridCoordinates(3, 5);
        GridSpace grid = new GridSpace(size);

        assertEquals(3, grid.getCells().length);
        assertEquals(5, grid.getCells()[0].length);
        assertEquals(0, grid.getCells()[0][0].length);
    }

    @Test
    void testGridSpaceInitialization3D() {
        GridCoordinates size = new GridCoordinates(3, 5, 12);
        GridSpace grid = new GridSpace(size);

        assertEquals(3, grid.getCells().length);
        assertEquals(5, grid.getCells()[0].length);
        assertEquals(12, grid.getCells()[0][0].length);
    }

    @Test
    void testRandomPositionInGridSpace()
    {
        for (int i = 0; i < 25; i++)
        {
            int x = (int) Randoms.range(0, 100, true);
            int y = (int) Randoms.range(0, 100, true);
            int z = (int) Randoms.range(0, 100, true);

            GridCoordinates size = new GridCoordinates(x, y, z);
            GridSpace grid = new GridSpace(size);

            GridCoordinates randomPosition = grid.getRandomPosition();

            assertNotNull(randomPosition);
            assertTrue(randomPosition.x() >= 0 && randomPosition.x() < x);
            assertTrue(randomPosition.y() >= 0 && randomPosition.y() < y);
            assertTrue(randomPosition.z() >= 0 && randomPosition.z() < z);
        }
    }
}
