package x_Example.BouncyGame;

import Core.SimpleKnightEngine;
import GameInput.BasicCameraControls;
import GameSpace.Vector.FreeVector;
import Objects.FreeObject.FreeBoundingCircle;
import Objects.Generic.Collidable;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;
import Rendering.Sprite;
import x_Example.SolarSystem.SolarObject;

import java.awt.*;
import java.util.List;

public class BouncyGameScene extends Scene
{
    private float MAX_X = 1000;
    private float MAX_Y = 1000;
    public BouncyGameScene(SimpleKnightEngine engine)
    {
        super(engine);

        int ballSize = 50;
        Sprite ballSprite = new Sprite(engine.getImageManager().getResource("src/main/java/x_Example/SolarSystem/sun.png"));
        MapIcon ballIcon = new MapIcon(ballSprite, 'o' ,Color.yellow, ballSize);
        FreeBoundingCircle ballCollider = new FreeBoundingCircle(ballSize);
        addRenderable(ballCollider);
        BouncyBall ball = new BouncyBall(this, ballIcon, FreeVector.create(100,100,0),
                ballCollider, MAX_X, MAX_Y);
        ball.setPosition(FreeVector.create(500,500,0));
        addGameObject(ball);

        FreeBoundingCircle ballCollider2 = new FreeBoundingCircle(ballSize);
        BouncyBall ball2 = new BouncyBall(this, ballIcon, FreeVector.create(100,100,0),
                ballCollider2, MAX_X, MAX_Y);
        addGameObject(ball2);
        addRenderable(ballCollider2);


        controls = new BasicCameraControls(this);
    }

    @Override
    public void drawScene(Graphics g) {
        drawRenderables(g);
        g.drawRect(0,0,(int)(MAX_X*getZoomLevel()),(int)(MAX_Y*getZoomLevel()));
    }

    @Override
    public void updateScene()
    {
        updateUpdateables();
        List<Collidable> safeCollidables = getCollidables();
        for (int i = 0; i < safeCollidables.size()-1; i++)
        {
            for (int j = i+1; j < safeCollidables.size(); j++)
            {
                //TODO: DOESN'T WORK YET
                if (safeCollidables.get(i).isCollidingWith(safeCollidables.get(j)))
                {
                    safeCollidables.get(i).collisionWith(safeCollidables.get(j));
                }
            }
        }
    }
}
