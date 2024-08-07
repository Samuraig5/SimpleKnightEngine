package GameSpace;

import Core.Settings;

public class GridCoordinates extends Coordinates<Integer>
{
    private final Integer[] coordinates = new Integer[3];

    public GridCoordinates(Integer x, Integer y, Integer z) {
        super(x, y, z);
        coordinates[0] = x;
        coordinates[1] = y;
        coordinates[2] = z;
    }
    public GridCoordinates(Integer x, Integer y) {
        super(x, y);
        coordinates[0] = x;
        coordinates[1] = y;
        coordinates[2] = 0;
    }

    @Override
    public Integer[] toArray() {
        return coordinates;
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
    public FreeCoordinates getRenderCoordinates() {

        return new FreeCoordinates(
                (double) x()*Settings.defaultGridSize,
                (double) y()*Settings.defaultGridSize,
                (double) z()*Settings.defaultGridSize);
    }
}
