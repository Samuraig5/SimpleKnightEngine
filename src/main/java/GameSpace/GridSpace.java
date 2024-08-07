package GameSpace;

import GameSpace.Vector.GridVector;
import MathHelper.Randoms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GridSpace
{
    private static final Logger logger = LoggerFactory.getLogger(GridSpace.class);
    private final Cell[][][] cells;
    private final GridVector size;

    /**
     * Creates a grid of cells given a size.
     * Will use the X and Y components of the given coordinates as the number of cells in that dimension.
     * Casts non int numbers to integers.
     * @param size X component: number of columns / Y component: number of rows.
     */
    public GridSpace(GridVector size)
    {
        this.size = size;
        cells = new Cell[size.x()][size.y()][size.z()];
    }

    public Cell[][][] getCells()
    {
        return cells;
    }

    public GridVector getSize()
    {
        return size;
    }

    public GridVector getRandomPosition()
    {
        int x = (int) Randoms.range(0, size.x()-1,true);
        int y = (int) Randoms.range(0, size.y()-1,true);
        int z = (int) Randoms.range(0, size.z()-1,true);
        logger.debug("Generated random position: (" + x + ", " + y + ", " + z + ").");
        return new GridVector(x,y,z);
    }
}
