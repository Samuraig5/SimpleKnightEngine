package GameSpace.Vector;

import MathHelper.Randoms;

public class FreeVector extends Vector<Double> {

    private final Double[] coordinates = new Double[3];

    public FreeVector(Double x,Double y,Double z) {set(x,y,z);}
    public FreeVector(Double x,Double y) {set(x,y,0d);}
    public FreeVector() {set(0d,0d,0d);}

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
        return new FreeVector(x(), y(), z());
    }

    @Override
    public void add(Vector<?> vector) {
        coordinates[0] += (Double) vector.x();
        coordinates[1] += (Double) vector.y();
        coordinates[2] += (Double) vector.z();
    }

    @Override
    public void randomize(double min, double max)
    {
        for (int i = 0; i < 3; i++) {
            coordinates[i] = Randoms.range(min, max,false);
        }
    }
}
