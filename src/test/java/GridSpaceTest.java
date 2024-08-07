import GameSpace.Coordinates;
import GameSpace.GridSpace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridSpaceTest
{
    @Test
    void testGridSpaceInitialization2D() {
        Coordinates<Integer> size = new Coordinates<>(3, 3);
        GridSpace grid = new GridSpace(size);

        assertEquals(3, grid.getCells().length);
        assertEquals(3, grid.getCells()[0].length);
        assertEquals(0, grid.getCells()[0][0].length);
    }

    @Test
    void testGridSpaceInitialization3D() {
        Coordinates<Integer> size = new Coordinates<>(3, 3, 3);
        GridSpace grid = new GridSpace(size);

        assertEquals(3, grid.getCells().length);
        assertEquals(3, grid.getCells()[0].length);
        assertEquals(3, grid.getCells()[0][0].length);
    }
}
