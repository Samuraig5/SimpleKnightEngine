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
    private static final Logger logger = LoggerFactory.getLogger(GridBoundVector.class);
    protected final GridSpace gridSpace;
    protected Cell myCell;

    public GridObject(GridSpace gridSpace, Scene scene, MapIcon mapIcon, Vector<?> vector) {
        super(scene, mapIcon, vector);
        this.gridSpace = gridSpace;
        setPosition(vector);
    }

    @Override
    public void update() {
        if (gridSpace == null)
        {
            logger.debug("GridObject has no GridSpace!");
            return;
        }
        super.update();
    }

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
}
