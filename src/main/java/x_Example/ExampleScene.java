package x_Example;

import Core.Settings;
import Core.SimpleKnightEngine;
import Rendering.SKRenderer.Scene;

import java.awt.*;

public class ExampleScene extends Scene
{
    public ExampleScene(SimpleKnightEngine engine) {
        super(engine);
    }

    @Override
    public void drawScene(Graphics g)
    {
        Image i = engine.getImageManager().getResource(Settings.missingTextureSprite);
        g.drawImage(i, 10, 10, 100, 100, engine.getRenderer());
        i = engine.getImageManager().getResource("Fake Path");
        g.drawImage(i, 150, 10, 100, 100, engine.getRenderer());
    }
}
