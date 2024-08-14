package GameSpace.Vector;

import Core.Settings;
import MathHelper.Randoms;

import java.awt.*;

public class IntegerVector extends Vector<Integer>
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
        RenderVector renderVector = new RenderVector();
        int x = (int) (x() * zoom);
        int y = (int) (y() * zoom);
        int z = (int) (z() * zoom);
        renderVector.set(x,y,z);
        return renderVector;
    }

    @Override
    public void add(Vector<?> vector) {
        int x = coordinates[0] + (Integer) vector.x();
        int y = coordinates[1] + (Integer) vector.y();
        int z = coordinates[2] + (Integer) vector.z();

        set(x,y,z);
    }

    @Override
    public void scale(double scalar) {
        set((int) (coordinates[0] * scalar), (int) (coordinates[1] * scalar), (int) (coordinates[2] * scalar));
    }

    @Override
    public void invert() {
        int x = -coordinates[0];
        int y = -coordinates[1];
        int z = -coordinates[2];

        set(x,y,z);
    }

    @Override
    public double distance(Vector<?> vector) {
        IntegerVector other = (IntegerVector) vector;
        return Math.sqrt(Math.pow(x() - other.x(), 2) +
                Math.pow(y() - other.y(), 2) +
                Math.pow(z() - other.z(), 2));
    }

    @Override
    public void randomize(double min, double max) {
        for (int i = 0; i < 3; i++) {
            coordinates[i] = (int) Randoms.range(min, max, true);
        }
    }

    public static IntegerVector create(Integer x, Integer y, Integer z)
    {
        IntegerVector vector = new IntegerVector();
        vector.set(x,y,z);
        return vector;
    }
    public static IntegerVector create(Point p)
    {
        IntegerVector vector = new IntegerVector();
        vector.set(p.x, p.y,0);
        return vector;
    }
}
