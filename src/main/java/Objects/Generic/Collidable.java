package Objects.Generic;

import GameSpace.Vector.Vector;

public interface Collidable {
    CollisionShape getCollisionShape();

    default boolean isCollidingWith(Collidable other) {
        return this.getCollisionShape().intersects(other.getCollisionShape());
    }

    void collisionWith(Collidable other);

    Vector<?> getPosition();

}

