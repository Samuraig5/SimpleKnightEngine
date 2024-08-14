package Objects.Generic;

import GameSpace.Vector.Vector;

public interface CollisionShape {
    boolean intersects(CollisionShape other);
    boolean intersects(Vector<?> point);
    Vector<?> getPosition();
}
