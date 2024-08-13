package Objects.Generic;

import GameSpace.Vector.Vector;

public interface CollisionShape {
    public abstract boolean intersects(CollisionShape other);
    void setPosition(Vector<?> position);
}
