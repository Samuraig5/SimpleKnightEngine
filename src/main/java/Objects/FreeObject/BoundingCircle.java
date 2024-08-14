package Objects.FreeObject;

import GameSpace.Vector.IntegerVector;
import GameSpace.Vector.Vector;
import Objects.Generic.CollisionShape;
import Objects.Generic.GameObject;
import Objects.Generic.Renderable;
import Rendering.SKRenderer.Scene;

import java.awt.*;

public class BoundingCircle implements CollisionShape, Renderable {

    private final Scene scene;
    private final FreeObject gameObject;
    private final double radius;

    public BoundingCircle(Scene scene, FreeObject gameObject, double radius) {
        this.scene = scene;
        this.gameObject = gameObject;
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }

    @Override
    public boolean intersects(CollisionShape other) {
        //TODO: FIX THIS
        if (other instanceof BoundingCircle) {
            BoundingCircle otherCircle = (BoundingCircle) other;
            double dx = getPosition().x() - otherCircle.getPosition().x();
            double dy = getPosition().y() - otherCircle.getPosition().y();
            double distance = (dx*dx) + (dy*dy);

            double circlesRadius = this.radius + otherCircle.radius;

            return distance < circlesRadius*circlesRadius; //Implementation without sqrt for better runtime
        }
        return false;
    }

    @Override
    public boolean intersects(Vector<?> point) {
        double distance = getPosition().distance(point);
        return distance < radius * scene.getZoomLevel();
    }

    @Override
    public IntegerVector getPosition()
    {
        return (IntegerVector) gameObject.getPosition();
    }

    //USED FOR DEBUGGING
    int renderPriority = 0;

    @Override
    public void render(Graphics g, Scene scene) {
        //TODO: DOESN'T WORK
    }

    @Override
    public void setRenderPriority(int priority) {
        renderPriority = priority;
    }

    @Override
    public int getRenderPriority() {
        return renderPriority;
    }
}
