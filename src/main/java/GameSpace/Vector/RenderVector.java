package GameSpace.Vector;

import MathHelper.Randoms;

import java.awt.*;

public class RenderVector extends IntegerVector
{
    @Override
    public RenderVector getRenderCoordinates(double zoom) {
        return this;
    }

    @Override
    public double distance(Vector<?> vector) {
        RenderVector other = vector.getRenderCoordinates(1);
        return Math.sqrt(Math.pow(x() - other.x(), 2) +
                        Math.pow(y() - other.y(), 2) +
                        Math.pow(z() - other.z(), 2));
    }

    public static RenderVector create(Integer x, Integer y, Integer z)
    {
        RenderVector vector = new RenderVector();
        vector.set(x,y,z);
        return vector;
    }
    public static RenderVector create(Integer x, Integer y)
    {
        RenderVector vector = new RenderVector();
        vector.set(x,y,0);
        return vector;
    }
    public static RenderVector create(Point p)
    {
        RenderVector vector = new RenderVector();
        vector.set(p.x, p.y,0);
        return vector;
    }
}
