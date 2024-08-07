package GameSpace.Vector;

import Core.Settings;
import MathHelper.Randoms;

public class GridVector extends Vector<Integer>
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
    public FreeVector getRenderCoordinates() {
        FreeVector renderVector = new FreeVector();
        renderVector.set(
                (double) x()*Settings.defaultGridSize,
                (double) y()*Settings.defaultGridSize,
                (double) z()*Settings.defaultGridSize);
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
    public void randomize(double min, double max) {
        for (int i = 0; i < 3; i++) {
            coordinates[i] = (int) Randoms.range(min, max,true);
        }
    }
}
