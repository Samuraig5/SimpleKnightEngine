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
    private final Circle circleDetection;
    public CollisionDetectionScene(SimpleKnightEngine engine) {
        super(engine);
        controls = new BasicCameraControls(this);

        pointDetection = new Circle(this,  IntegerVector.create(0,0,0), 50d);
        addGameObject(pointDetection);

        mouseCircle = new Circle(this,  IntegerVector.create(100,100,0), 15d);
        addGameObject(mouseCircle);

        circleDetection = new Circle(this,  IntegerVector.create(200,0,0), 50d);
        addGameObject(circleDetection);

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
        pointDetection.render(g,this);
        g.setColor(Color.black);
        IntegerVector text1Pos = IntegerVector.create(-75, -75, 0);
        RenderVector text1RendPos = text1Pos.getRenderCoordinates(getZoomLevel());
        g.drawString("Point Detection (with mouse)", text1RendPos.x(), text1RendPos.y());


        if (circleDetection.isCollidingWith(mouseCircle))
        {
            g.setColor(Color.red);
        }
        else
        {
            g.setColor(Color.green);
        }
        circleDetection.render(g,this);
        g.setColor(Color.black);
        IntegerVector text2Pos = IntegerVector.create(100, -75, 0);
        RenderVector text2RendPos = text2Pos.getRenderCoordinates(getZoomLevel());
        g.drawString("Collision Detection (with circle on mouse)", text2RendPos.x(), text2RendPos.y());

        mouseCircle.render(g,this);

        g.drawLine(-10000, 0, 10000,0);
        g.drawLine(0, -10000, 0,10000);
        g.drawString(getMouseWorldPosition().toString(), getMouseWorldPosition().x(), getMouseWorldPosition().y()-25);
    }

    @Override
    public void updateScene()
    {
        mouseCircle.setPosition(getMouseWorldPosition().getWorldCoordinates(getZoomLevel()));
        updateUpdateables();
    }
}
