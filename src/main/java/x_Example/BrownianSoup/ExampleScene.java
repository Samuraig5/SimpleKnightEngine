package x_Example.BrownianSoup;

import GameInput.BasicCameraControls;
import GameSpace.Vector.GridBoundVector;
import Objects.GameObject;
import Core.Settings;
import Core.SimpleKnightEngine;
import GameSpace.Vector.GridVector;
import GameSpace.GridSpace;
import MathHelper.Randoms;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;
import Rendering.Sprite;

import java.awt.*;

public class ExampleScene extends Scene
{
    public ExampleScene(SimpleKnightEngine engine)
    {
        super(engine);

        controls = new BasicCameraControls(this);

        GridVector gridSize = new GridVector();
        gridSize.set(100,100);
        GridSpace grid = new GridSpace(gridSize);
        addRenderable(grid);

        Image i = engine.getImageManager().getResource(Settings.missingTextureSprite);
        Sprite sprite = new Sprite(i, true);
        MapIcon mapIcon = new MapIcon(sprite,'?',Color.lightGray);

        for (int j = 0; j < 10; j++) {
            GridBoundVector gridPos = grid.getRandomPosition();
            GameObject gameObject = new BrownianMovement(grid, this, mapIcon, gridPos);
            addGameObject(gameObject);
        }
        Double x = Randoms.range(0,1000,false);
        Double y = Randoms.range(0,1000,false);

        //FreeVector freePos = new FreeVector();
        //freePos.set(x,y);

        //GameObject gameObject = new GameObject(this, mapIcon, freePos);
        //renderables.add(gameObject);
        //updatables.add(gameObject);
    }

    @Override
    public void drawScene(Graphics g)
    {
        drawRenderables(g);
    }

    @Override
    public void updateScene()
    {
        updateUpdateables();
    }
}
