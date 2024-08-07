package x_Example;

import Core.GameObject;
import Core.Settings;
import Core.SimpleKnightEngine;
import GameSpace.Coordinates;
import GameSpace.FreeCoordinates;
import GameSpace.GridCoordinates;
import GameSpace.GridSpace;
import MathHelper.Randoms;
import Rendering.GridRenderer;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;
import Rendering.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ExampleScene extends Scene
{
    private final GridSpace grid;
    private final List<GameObject> objects = new ArrayList<>();
    public ExampleScene(SimpleKnightEngine engine)
    {
        super(engine);
        GridCoordinates gridSize = new GridCoordinates(7,7);
        grid = new GridSpace(gridSize);

        Image i = engine.getImageManager().getResource(Settings.missingTextureSprite);
        Sprite sprite = new Sprite(i, true);
        MapIcon mapIcon = new MapIcon(sprite,'?',Color.lightGray);

        for (int j = 0; j < 3; j++) {
            GridCoordinates gridPos = grid.getRandomPosition();
            GameObject gameObject = new GameObject(mapIcon, gridPos);
            objects.add(gameObject);
        }
        Double x = Randoms.range(0,1000,false);
        Double y = Randoms.range(0,1000,false);

        FreeCoordinates freePos = new FreeCoordinates(x, y);
        GameObject gameObject = new GameObject(mapIcon, freePos);
        objects.add(gameObject);
    }

    @Override
    public void drawScene(Graphics g)
    {
        GridRenderer.drawGrid(g,this,grid);

        for (GameObject obj:objects)
        {
            obj.render(g,this);
        }
        //Image i = engine.getImageManager().getResource(Settings.missingTextureSprite);
        //g.drawImage(i, 10, 10, 100, 100, engine.getRenderer());
        //i = engine.getImageManager().getResource("Fake Path");
        //g.drawImage(i, 150, 10, 100, 100, engine.getRenderer());
    }
}
