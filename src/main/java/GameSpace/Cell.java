package GameSpace;

import GameSpace.Vector.GridBoundVector;
import Objects.Generic.GameObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Cell
{
    /**
     * Logger used for logging
     */
    private static final Logger logger = LoggerFactory.getLogger(Cell.class);
    /**
     * List of all the gameObjects found within this cell
     */
    public final List<GameObject> gameObjects = new ArrayList<>();
    /**
     * Position of the Cell on the Grid
     */
    private final GridBoundVector position;
    public Cell(GridBoundVector position)
    {
        this.position = position;
    }
    public GridBoundVector getPosition() {
        return position;
    }
}
