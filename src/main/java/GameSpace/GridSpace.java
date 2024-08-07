package GameSpace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class GridSpace
{
    private static final Logger logger = LoggerFactory.getLogger(GridSpace.class);
    private final Cell[][][] cells;
    private final Coordinates<? extends Number> size;

    /**
     * Creates a grid of cells given a size.
     * Will use the X and Y components of the given coordinates as the number of cells in that dimension.
     * Casts non int numbers to integers.
     * @param size X component: number of columns / Y component: number of rows.
     */
    public GridSpace(Coordinates<? extends Number> size)
    {
        this.size = size;
        cells = new Cell[(int) size.x()][(int) size.y()][(int) size.z()];
    }

    public Cell[][][] getCells()
    {
        return cells;
    }

    public Coordinates<? extends Number> getSize()
    {
        return size;
    }
}
