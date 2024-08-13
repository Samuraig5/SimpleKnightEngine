package Objects.FreeObject;

import GameSpace.Vector.Vector;
import Objects.Generic.Collidable;
import Objects.Generic.CollisionShape;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;

public abstract class FreeSolid extends FreeObject implements Collidable
{
    private final CollisionShape collisionShape;

    public FreeSolid(Scene scene, MapIcon mapIcon, Vector<?> position, CollisionShape collisionShape) {
        super(scene, mapIcon, position);
        this.collisionShape = collisionShape;
        collisionShape.setPosition(getPosition());
    }

    @Override
    public CollisionShape getCollisionShape() {
        return collisionShape;
    }
}
