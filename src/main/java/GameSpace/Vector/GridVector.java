package GameSpace.Vector;

import Core.Settings;
import MathHelper.Randoms;

public class GridVector extends Vector<Integer>
{
    private final Integer[] coordinates = new Integer[3];

    public GridVector(Integer x, Integer y,Integer z){set(x,y,z);}
    public GridVector(Integer x, Integer y){set(x,y,0);}
    public GridVector(){set(0,0,0);}

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

        return new FreeVector(
                (double) x()*Settings.defaultGridSize,
                (double) y()*Settings.defaultGridSize,
                (double) z()*Settings.defaultGridSize);
    }

    @Override
    public void add(Vector<?> vector) {
        coordinates[0] += (Integer) vector.x();
        coordinates[1] += (Integer) vector.y();
        coordinates[2] += (Integer) vector.z();
    }

    @Override
    public void randomize(double min, double max) {
        for (int i = 0; i < 3; i++) {
            coordinates[i] = (int) Randoms.range(min, max,true);
        }
    }
}
