package GameSpace.Vector;

import GameSpace.GridSpace;
import MathHelper.Basics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class GridBoundVector extends GridVector
{
    private static final Logger logger = LoggerFactory.getLogger(GridVector.class);

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
        if (gridSpace != null)
        {
            int xMax = gridSpace.getSize().x();
            int yMax = gridSpace.getSize().y();
            int zMax = gridSpace.getSize().z();

            x = Basics.clamp(x,0,xMax-1);
            y = Basics.clamp(y,0,yMax-1);
            z = Basics.clamp(z,0,zMax-1);
        }
        else
        {
            logger.info("gridSpace is null");
        }

        super.set(x, y, z);
    }
}
