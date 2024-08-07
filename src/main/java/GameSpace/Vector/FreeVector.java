package GameSpace.Vector;

import MathHelper.Randoms;

public class FreeVector extends Vector<Double> {

    /**
     * Components of the Vector, stored as doubles
     */
    private final Double[] coordinates = {0d,0d,0d};

    @Override
    public Double zero() {
        return 0d;
    }

    @Override
    public Double[] toArray() {
        return coordinates;
    }

    @Override
    public void set(Double x, Double y, Double z) {
        coordinates[0] = x;
        coordinates[1] = y;
        coordinates[2] = z;
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
    public FreeVector getRenderCoordinates() {
        FreeVector renderVector = new FreeVector();
        renderVector.set(x(), y(), z());
        return renderVector;
    }

    @Override
    public void add(Vector<?> vector) {
        double x = coordinates[0] + (Double) vector.x();
        double y = coordinates[1] + (Double) vector.y();
        double z = coordinates[2] + (Double) vector.z();

        set(x,y,z);
    }

    @Override
    public void randomize(double min, double max)
    {
        for (int i = 0; i < 3; i++) {
            coordinates[i] = Randoms.range(min, max,false);
        }
    }
}
