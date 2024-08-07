package x_Example;

import Core.Settings;
import Core.SimpleKnightEngine;
import GameSpace.Coordinates;
import GameSpace.GridSpace;
import Rendering.GridRenderer;
import Rendering.SKRenderer.Scene;

import java.awt.*;

public class ExampleScene extends Scene
{
    private final GridSpace grid;
    public ExampleScene(SimpleKnightEngine engine)
    {
        super(engine);
        grid = new GridSpace(new Coordinates<>(10,10));
    }

    @Override
    public void drawScene(Graphics g)
    {
        GridRenderer.drawGrid(g,this,grid);
        Image i = engine.getImageManager().getResource(Settings.missingTextureSprite);
        g.drawImage(i, 10, 10, 100, 100, engine.getRenderer());
        i = engine.getImageManager().getResource("Fake Path");
        g.drawImage(i, 150, 10, 100, 100, engine.getRenderer());
    }
}
