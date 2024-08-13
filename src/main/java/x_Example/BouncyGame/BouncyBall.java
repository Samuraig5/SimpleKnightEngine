package x_Example.BouncyGame;

import GameSpace.Vector.FreeVector;
import GameSpace.Vector.Vector;
import Objects.FreeObject.FreeBoundingCircle;
import Objects.FreeObject.FreeSolid;
import Objects.Generic.Collidable;
import Objects.Generic.CollisionShape;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;

public class BouncyBall extends FreeSolid {
    private FreeVector movement;
    private float MAX_X;
    private float MAX_Y;

    public BouncyBall(Scene scene, MapIcon mapIcon, Vector<?> position,
                      CollisionShape collisionShape, float MAX_X, float MAX_Y) {
        super(scene, mapIcon, position, collisionShape);
        movement = new FreeVector();
        movement.randomize(1, 10);
        movement.set(movement.x(), movement.y(), 0d);

        this.MAX_X = MAX_X;
        this.MAX_Y = MAX_Y;
    }

    @Override
    public void collisionWith(Collidable other)
    {
        Vector<Double> normal = calculateCollisionNormal(other);

        // Calculate the reflection vector based on the collision normal
        double dotProduct = movement.x() * normal.x() + movement.y() * normal.y();
        double reflectionX = movement.x() - 2 * dotProduct * normal.x();
        double reflectionY = movement.y() - 2 * dotProduct * normal.y();

        movement.set(reflectionX, reflectionY);
    }

    private Vector<Double> calculateCollisionNormal(Collidable other) {
        FreeVector position = (FreeVector) this.getPosition();
        FreeVector otherPosition = (FreeVector) other.getPosition();

        // Example normal calculation (this is just a placeholder):
        double normalX = position.x() - otherPosition.x();
        double normalY = position.y() - otherPosition.y();
        double length = Math.sqrt(normalX * normalX + normalY * normalY);

        return FreeVector.create(normalX / length, normalY / length, 0d);
    }

    @Override
    public void update() {
        super.update();

        FreeVector position = (FreeVector) getPosition();
        double nextX = position.x() + movement.x();
        double nextY = position.y() + movement.y();

        FreeBoundingCircle collider = (FreeBoundingCircle)getCollisionShape();
        double radius = collider.getRadius();

        // Boundary collision detection
        if (nextX-radius < 0 || nextX+radius > MAX_X) {
            movement.set(-movement.x(), movement.y(), movement.z());
            nextX = Math.max(0, Math.min(nextX, MAX_X));
        }

        if (nextY-radius < 0 || nextY+radius > MAX_Y) {
            movement.set(movement.x(), -movement.y(), movement.z());
            nextY = Math.max(0, Math.min(nextY, MAX_Y));
        }

        setPosition(FreeVector.create(nextX, nextY, 0));
    }
}
