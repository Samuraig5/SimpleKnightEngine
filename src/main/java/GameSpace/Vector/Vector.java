package GameSpace.Vector;

import MathHelper.Basics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Vector<T extends Number & Comparable<T>>
{
    /**
     * Logger used for logging
     */
    private static final Logger logger = LoggerFactory.getLogger(Vector.class);

    /**
     * Overrides this vector to match the source vector.
     * @param source source vector
     */
    public void copy(Vector<?> source)
    {
        set((T) source.x(), (T) source.y(), (T) source.z());
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
     * Sets the x and y component of a 2D vector. The z component is set to 0.
     * @param x x component
     * @param y y component
     */
    public void set(T x, T y)
    {
        set(x, y, zero());
    }

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
     * Returns the coordinates at which this vector should be rendered at.
     * @return coordinates of the render position scaled by zoom level
     */
    public abstract RenderVector getRenderCoordinates(double zoom);

    /**
     * Adds the given vector to this vector
     * @param vector the vector to be added
     */
    public abstract void add(Vector<?> vector);
    public abstract void scale(double scalar);
    public abstract void invert();

    public abstract double distance(Vector<?> vector);

    /**
     * Overrides this vector, randomizing each component to be between min and max
     * @param min min value (inclusive)
     * @param max max value (inclusive)
     */
    public abstract void randomize(double min, double max);

    public String toString()
    {
        return "( " + x().toString() + ", " + y().toString() + ", " + z().toString() + " )";
    }
}
