package GameSpace.Vector;

import MathHelper.Basics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.PortUnreachableException;

public abstract class Vector<T extends Number & Comparable<T>>
{
    private static final Logger logger = LoggerFactory.getLogger(Vector.class);

    public void clamp(T min, T max)
    {
        T[] coords = toArray();
        for (int i = 0; i < 3; i++)
        {
            coords[i] = Basics.clamp(coords[i], min, max);
        }
        set(coords[0], coords[1], coords[2]);
    }

    /**
     * @return the zero value for the vector.
     */
    public abstract T zero();

    /**
     * @return Coordinates as a 1x3 array. [0] is the X component, [1] is the Y component, and [2] is the Z component.
     */
    public abstract T[] toArray();

    /**
     * Sets components of the vector
     * @param x x component
     * @param y y component
     * @param z z component
     */
    public abstract void set(T x, T y, T z);

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
    public abstract FreeVector getRenderCoordinates();

    /**
     * Adds the given vector to this vector
     * @param vector the vector to be added
     */
    public abstract void add(Vector<?> vector);

    /**
     * Overrides this vector, randomizing each component to be between min and max
     * @param min min value (inclusive)
     * @param max max value (inclusive)
     */
    public abstract void randomize(double min, double max);
}
