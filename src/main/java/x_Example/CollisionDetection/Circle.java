package x_Example.CollisionDetection;

import GameSpace.Vector.IntegerVector;
import GameSpace.Vector.Vector;
import Objects.FreeObject.BoundingCircle;
import Objects.FreeObject.FreeSolid;
import Objects.Generic.Collidable;
import Objects.Generic.CollisionShape;
import Rendering.SKRenderer.Scene;

import java.awt.*;

public class Circle extends FreeSolid
{
    private final double radius;

    public Circle(Scene scene, IntegerVector position, Double radius) {
        super(scene, null, position);
        this.radius = radius;
        CollisionShape collisionShape = new BoundingCircle(scene, this, radius);
        setCollisionShape(collisionShape);
    }

    @Override
    public void collision(Collidable other) {

    }

    @Override
    public void render(Graphics g, Scene scene) {

        double radZoomed = radius* scene.getZoomLevel();
        double diameter = radZoomed*2;

        IntegerVector topleft = IntegerVector.create(
                getRenderCoordinates().x()-(int)radZoomed,
                getRenderCoordinates().y()-(int)radZoomed, 0);

        IntegerVector size = IntegerVector.create(
                (int) (diameter),
                (int) (diameter),0);

        g.fillOval(topleft.x(), topleft.y(),size.x(),size.y());
    }
}
