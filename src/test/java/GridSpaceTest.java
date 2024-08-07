import GameSpace.Vector.GridVector;
import GameSpace.GridSpace;
import MathHelper.Randoms;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridSpaceTest
{
    @Test
    void testGridSpaceInitialization2D() {
        GridVector size = new GridVector(3, 5);
        GridSpace grid = new GridSpace(size);

        assertEquals(3, grid.getCells().length);
        assertEquals(5, grid.getCells()[0].length);
        assertEquals(0, grid.getCells()[0][0].length);
    }

    @Test
    void testGridSpaceInitialization3D() {
        GridVector size = new GridVector(3, 5, 12);
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

            GridVector size = new GridVector(x, y, z);
            GridSpace grid = new GridSpace(size);

            GridVector randomPosition = grid.getRandomPosition();

            assertNotNull(randomPosition);
            assertTrue(randomPosition.x() >= 0 && randomPosition.x() < x);
            assertTrue(randomPosition.y() >= 0 && randomPosition.y() < y);
            assertTrue(randomPosition.z() >= 0 && randomPosition.z() < z);
        }
    }
}
