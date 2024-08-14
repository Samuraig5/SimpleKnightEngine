package Objects.FreeObject;

import GameSpace.Vector.IntegerVector;
import Objects.Generic.Collidable;
import Objects.Generic.CollisionShape;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;

public abstract class FreeSolid extends FreeObject implements Collidable
{
    private CollisionShape collisionShape;

    public FreeSolid(Scene scene, MapIcon mapIcon, IntegerVector position, CollisionShape collisionShape) {
        super(scene, mapIcon, position);
        this.collisionShape = collisionShape;
    }
    public FreeSolid(Scene scene, MapIcon mapIcon, IntegerVector position){
        super(scene, mapIcon, position);
    }

    @Override
    public CollisionShape getCollisionShape() {
        return collisionShape;
    }
    @Override
    public void setCollisionShape(CollisionShape collisionShape) {this.collisionShape = collisionShape;}
}
