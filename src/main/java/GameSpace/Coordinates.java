package GameSpace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Coordinates<T extends Number> {
    private static final Logger logger = LoggerFactory.getLogger(Coordinates.class);
    private final T[] coordinates;

    @SuppressWarnings("unchecked")
    public Coordinates(T x, T y) {
        this.coordinates = (T[]) new Number[3]; // Initialize with three elements
        this.coordinates[0] = x;
        this.coordinates[1] = y;
        this.coordinates[2] = (T) Integer.valueOf(0); // Default value for z-coordinate
    }

    @SuppressWarnings("unchecked")
    public Coordinates(T x, T y, T z) {
        this.coordinates = (T[]) new Number[3];
        this.coordinates[0] = x;
        this.coordinates[1] = y;
        this.coordinates[2] = z;
    }

    /**
     * @return Coordinates as a 1x3 array. [0] is the X component, [1] is the Y component, and [2] is the Z component.
     */
    public T[] toArray() {
        return Arrays.copyOf(coordinates, coordinates.length); // Return a copy to maintain immutability
    }

    /**
     * @return X component of the coordinate.
     */
    public T x() {
        return coordinates[0];
    }

    /**
     * @return Y component of the coordinate.
     */
    public T y() {
        return coordinates[1];
    }

    /**
     * @return Z component of the coordinate.
     */
    public T z() {
        return coordinates[2];
    }
}
