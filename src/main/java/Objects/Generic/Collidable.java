package Objects.Generic;

import GameSpace.Vector.Vector;

public interface Collidable {
    CollisionShape getCollisionShape();
    void setCollisionShape(CollisionShape collisionShape);

    default boolean isCollidingWith(Collidable other) {
        return this.getCollisionShape().intersects(other.getCollisionShape());
    }
    default boolean isCollidingWith(Vector<?> other) {
        return this.getCollisionShape().intersects(other);
    }

    void collision(Collidable other);

    Vector<?> getPosition();
}

