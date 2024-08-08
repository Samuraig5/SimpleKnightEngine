package GameSpace.Vector;

import GameSpace.GridSpace;
import MathHelper.Basics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class GridBoundVector extends GridVector
{
    /**
     * Logger used for logging
     */
    private static final Logger logger = LoggerFactory.getLogger(GridBoundVector.class);
    /**
     * The gridSpace associated with this GridBoundVector
     */
    private final GridSpace gridSpace;

    public GridBoundVector(GridSpace gridSpace) {this.gridSpace = gridSpace;}

    /**
     * @inheritDoc
     * Before the normal setting behaviour, this method makes sure that the components are
     * clamped within the bounds of the gridSpace associated with this vector.
     * @param x x component
     * @param y y component
     * @param z z component
     */
    @Override
    public void set(Integer x, Integer y, Integer z)
    {
        int xMax = Math.max(0, gridSpace.getSize().x()-1);
        int yMax = Math.max(0, gridSpace.getSize().y()-1);
        int zMax = Math.max(0, gridSpace.getSize().z()-1);

        x = Basics.clamp(x,0,xMax);
        y = Basics.clamp(y,0,yMax);
        z = Basics.clamp(z,0,zMax);

        super.set(x, y, z);
    }

    public static GridBoundVector create(GridSpace gridSpace, Integer x, Integer y, Integer z)
    {
        GridBoundVector vector = new GridBoundVector(gridSpace);
        vector.set(x,y,z);
        return vector;
    }
}
