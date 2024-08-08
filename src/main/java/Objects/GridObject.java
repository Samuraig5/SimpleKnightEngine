package Objects;

import GameSpace.Cell;
import GameSpace.GridSpace;
import GameSpace.Vector.GridBoundVector;
import GameSpace.Vector.Vector;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GridObject extends GameObject
{
    /**
     * Logger used for logging
     */
    private static final Logger logger = LoggerFactory.getLogger(GridBoundVector.class);
    /**
     * GridSpace the GridObject is inside of
     */
    protected final GridSpace gridSpace;
    /**
     * Cell the GridObject is currently inside of
     */
    protected Cell myCell;

    public GridObject(GridSpace gridSpace, Scene scene, MapIcon mapIcon, Vector<?> vector) {
        super(scene, mapIcon, vector);
        this.gridSpace = gridSpace;
        setPosition(vector);
    }

    /**
     * @inheritDoc
     * Before any of the normal behavior of a GameObject, aborts the update
     * of the GridObject if it is not assignedto any gridSpace
     */
    @Override
    public void update() {
        if (gridSpace == null)
        {
            logger.debug("GridObject has no GridSpace!");
            return;
        }
        super.update();
    }

    /**
     * @inheritDoc
     *  On top of the normal behavior of a GameObject,
     *  also updates the cell the GridObject is leaving and the cell the GridObject is moving into.
     */
    @Override
    public void setPosition(Vector<?> newPosition)
    {
        if (gridSpace == null)
        {
            super.setPosition(newPosition);
            return;
        }

        GridBoundVector newVector = new GridBoundVector(gridSpace);
        newVector.copy(newPosition);

        super.setPosition(newVector);

        if (myCell != null)
        {
            myCell.gameObjects.remove(this);
        }
        myCell = gridSpace.getCells()[newVector.x()][newVector.y()][newVector.z()];
        myCell.gameObjects.add(this);
    }

    @Override
    public void delete(String deleteMessage) {
        super.delete(deleteMessage);
        if (myCell != null)
        {
            myCell.gameObjects.remove(this);
        }
    }
}
