package GameSpace;

import GameSpace.Vector.GridBoundVector;
import GameSpace.Vector.GridVector;
import MathHelper.Randoms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GridSpace
{
    /**
     * Logger for logging
     */
    private static final Logger logger = LoggerFactory.getLogger(GridSpace.class);
    /**
     * Three-dimensional array holding the cells of this GridSpace.
     * In a two-dimensional plane, the third dimension has a size of one.
     */
    private final Cell[][][] cells;
    /**
     * Vector representing the size of the GridSpace.
     * Each component corresponds to the size of its associated dimension.
     */
    private final GridVector size;

    /**
     * Creates a grid of cells given a size.
     * It takes a GridVector as an input.
     * The scale of each component of the vector determines the size of the corresponding dimension.
     * If the input vector contains non integer numbers, they are cast to integer numbers.
     * Will replace any numbers below '1' with '1' to ensure that each dimension has atleast a size of one.
     *
     * @param size X component: number of columns / Y component: number of rows.
     */
    public GridSpace(GridVector size)
    {
        int x = Math.max(1,size.x());
        int y = Math.max(1,size.y());
        int z = Math.max(1,size.z());

        size.set(x,y,z);

        this.size = size;
        cells = new Cell[size.x()][size.y()][size.z()];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    cells[i][j][k] = new Cell();
                }
            }
        }
    }

    /**
     * @return Three-dimensional array containing the cells of the GridSpace.
     */
    public Cell[][][] getCells()
    {
        return cells;
    }

    /**
     * @return size of the GridSpace
     */
    public GridVector getSize()
    {
        return size;
    }

    /**
     * Generates a random position contained within the GridSpace and returns it as a GridBoundVector.
     * @return GridBoundVector of the random position
     */
    public GridBoundVector getRandomPosition()
    {
        int x = (int) Randoms.range(0, size.x()-1,true);
        int y = (int) Randoms.range(0, size.y()-1,true);
        int z = (int) Randoms.range(0, size.z()-1,true);
        logger.debug("Generated random position: (" + x + ", " + y + ", " + z + ").");
        return new GridBoundVector(this);
    }
}
