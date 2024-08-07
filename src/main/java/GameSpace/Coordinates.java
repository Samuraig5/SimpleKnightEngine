package GameSpace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public abstract class Coordinates<T extends Number>
{
    private static final Logger logger = LoggerFactory.getLogger(Coordinates.class);

    public Coordinates(T x, T y, T z) {}
    public Coordinates(T x, T y) {}

    /**
     * @return Coordinates as a 1x3 array. [0] is the X component, [1] is the Y component, and [2] is the Z component.
     */
    public abstract T[] toArray();

    /**
     * @return X component of the coordinate.
     */
    public abstract T x();

    /**
     * @return Y component of the coordinate.
     */
    public abstract T y();

    /**
     * @return Z component of the coordinate.
     */
    public abstract T z();

    /**
     * @return coordinates of the render position. NOT scaled by zoom level
     */
    public abstract FreeCoordinates getRenderCoordinates();
}
