package x_Example.CollisionDetection;

import Core.SimpleKnightEngine;
import GameInput.BasicCameraControls;
import GameSpace.Vector.IntegerVector;
import GameSpace.Vector.RenderVector;
import Rendering.SKRenderer.Scene;

import java.awt.*;

public class CollisionDetectionScene extends Scene {
    private final Circle pointDetection;
    private final Circle mouseCircle;
    public CollisionDetectionScene(SimpleKnightEngine engine) {
        super(engine);
        controls = new BasicCameraControls(this);

        pointDetection = new Circle(this,  IntegerVector.create(0,0,0), 50d);
        addGameObject(pointDetection);

        mouseCircle = new Circle(this,  IntegerVector.create(100,100,0), 25d);
        addGameObject(mouseCircle);

        setCameraOffset(RenderVector.create(700,400,0));
    }

    @Override
    public void drawScene(Graphics g) {
        if (pointDetection.isCollidingWith(getMouseWorldPosition()))
        {
            g.setColor(Color.red);
        }
        else
        {
            g.setColor(Color.green);
        }
        drawRenderables(g);
        g.setColor(Color.black);
        g.drawLine(-10000, 0, 10000,0);
        g.drawLine(0, -10000, 0,10000);
        g.drawString(getMouseWorldPosition().toString(), getMouseWorldPosition().x(), getMouseWorldPosition().y());
    }

    @Override
    public void updateScene()
    {
        mouseCircle.setPosition(getMouseWorldPosition());
        updateUpdateables();
    }
}
