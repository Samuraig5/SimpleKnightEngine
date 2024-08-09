package GameSpace.Vector;

import MathHelper.Randoms;

import java.awt.*;

public class RenderVector extends Vector<Integer>
{
    private final Integer[] coordinates = {0,0,0};

    @Override
    public Integer zero() {
        return 0;
    }

    @Override
    public Integer[] toArray() {
        return coordinates;
    }

    @Override
    public void set(Integer x, Integer y, Integer z) {
        coordinates[0] = x;
        coordinates[1] = y;
        coordinates[2] = z;
    }

    @Override
    public Integer x() {
        return coordinates[0];
    }

    @Override
    public Integer y() {
        return coordinates[1];
    }

    @Override
    public Integer z() {
        return coordinates[2];
    }

    @Override
    public RenderVector getRenderCoordinates(double zoom) {
        return this;
    }

    @Override
    public void add(Vector<?> vector) {
        int x = coordinates[0] + (Integer) vector.x();
        int y = coordinates[1] + (Integer) vector.y();
        int z = coordinates[2] + (Integer) vector.z();

        set(x,y,z);
    }

    @Override
    public void randomize(double min, double max) {
        for (int i = 0; i < 3; i++) {
            coordinates[i] = (int) Randoms.range(min, max, true);
        }
    }

    public static RenderVector create(Integer x, Integer y, Integer z)
    {
        RenderVector vector = new RenderVector();
        vector.set(x,y,z);
        return vector;
    }
    public static RenderVector create(Point p)
    {
        RenderVector vector = new RenderVector();
        vector.set(p.x, p.y,0);
        return vector;
    }
}
