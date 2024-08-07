package GameSpace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class FreeCoordinates extends Coordinates<Double>{

    private final Double[] coordinates = new Double[3];

    public FreeCoordinates(Double x, Double y, Double z) {
        super(x, y, z);
        coordinates[0] = x;
        coordinates[1] = y;
        coordinates[2] = z;
    }
    public FreeCoordinates(Double x, Double y) {
        super(x, y);
        coordinates[0] = x;
        coordinates[1] = y;
        coordinates[2] = (double) 0;
    }

    @Override
    public Double[] toArray() {
        return coordinates;
    }

    @Override
    public Double x() {
        return coordinates[0];
    }

    @Override
    public Double y() {
        return coordinates[1];
    }

    @Override
    public Double z() {
        return coordinates[2];
    }

    @Override
    public FreeCoordinates getRenderCoordinates() {
        return new FreeCoordinates(x(), y(), z());
    }
}
