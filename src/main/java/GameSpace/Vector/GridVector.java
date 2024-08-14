package GameSpace.Vector;

import Core.Settings;
import GameSpace.GridSpace;
import MathHelper.Randoms;

public class GridVector extends IntegerVector
{
    /**
     * Component of the vector, stored as integers
     */
    private final Integer[] coordinates = {0,0,0};

    @Override
    public RenderVector getRenderCoordinates(double zoom) {
        RenderVector renderVector = new RenderVector();
        int x = x() * (int)Math.round(Settings.defaultGridSize * zoom);
        int y = y() * (int)Math.round(Settings.defaultGridSize * zoom);
        int z = z() * (int)Math.round(Settings.defaultGridSize * zoom);
        renderVector.set(x,y,z);
        return renderVector;
    }

    public static GridVector create(Integer x, Integer y, Integer z)
    {
        GridVector vector = new GridVector();
        vector.set(x,y,z);
        return vector;
    }
}
