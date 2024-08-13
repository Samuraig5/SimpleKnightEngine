package x_Example.BouncyGame;

import GameSpace.Vector.Vector;
import Objects.FreeObject.FreeSolid;
import Objects.Generic.Collidable;
import Objects.Generic.CollisionShape;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;

public class Character extends FreeSolid {
    public Character(Scene scene, MapIcon mapIcon, Vector<?> position, CollisionShape collisionShape) {
        super(scene, mapIcon, position, collisionShape);
    }

    @Override
    public void collisionWith(Collidable other) {
        if (other instanceof BouncyBall)
        {
            //Defeat
        }
    }
}
