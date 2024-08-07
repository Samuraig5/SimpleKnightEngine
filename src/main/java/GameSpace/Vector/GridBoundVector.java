package GameSpace.Vector;

import GameSpace.GridSpace;
import MathHelper.Basics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class GridBoundVector extends GridVector
{
    private static final Logger logger = LoggerFactory.getLogger(GridBoundVector.class);

    private final GridSpace gridSpace;

    public GridBoundVector(GridSpace gridSpace, Integer x, Integer y,Integer z)
    {
        this.gridSpace = gridSpace;
        set(x,y,z);
    }
    public GridBoundVector(GridSpace gridSpace, Integer x, Integer y)
    {
        this.gridSpace = gridSpace;
        set(x,y,0);
    }
    public GridBoundVector(GridSpace gridSpace)
    {
        this.gridSpace = gridSpace;
        set(0,0,0);
    }

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
}
