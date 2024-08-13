package Objects.FreeObject;

import GameSpace.Vector.FreeVector;
import GameSpace.Vector.RenderVector;
import GameSpace.Vector.Vector;
import Objects.Generic.CollisionShape;
import Objects.Generic.Renderable;
import Rendering.SKRenderer.Scene;

import java.awt.*;

public class FreeBoundingCircle implements CollisionShape, Renderable {
    private FreeVector position;
    private final double radius;

    public FreeBoundingCircle(double radius) {
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }

    @Override
    public boolean intersects(CollisionShape other) {
        if (other instanceof FreeBoundingCircle) {
            FreeBoundingCircle otherCircle = (FreeBoundingCircle) other;
            double dx = this.position.x() - otherCircle.position.x();
            double dy = this.position.y() - otherCircle.position.y();
            double distance = (dx*dx) + (dy*dy);

            double circlesRadius = this.radius + otherCircle.radius;

            return distance < circlesRadius*circlesRadius; //Implementation without sqrt for better runtime
        }
        return false;
    }

    @Override
    public void setPosition(Vector<?> position)
    {
        this.position = (FreeVector) position;
    }

    //USED FOR DEBUGGING
    int renderPriority = 0;

    @Override
    public void render(Graphics g, Scene scene) {
        RenderVector renderCoords = position.getRenderCoordinates(scene.getZoomLevel());
        int renderSize = (int) Math.round(radius * scene.getZoomLevel());

        RenderVector objectOffset = RenderVector.create(-renderSize/2, -renderSize/2, 0);
        renderCoords.add(objectOffset);

        g.drawOval(renderCoords.x(),renderCoords.y(),renderSize, renderSize);
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
