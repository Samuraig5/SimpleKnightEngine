package Rendering.SKRenderer;

import Core.SimpleKnightEngine;

import java.awt.*;

public abstract class Scene
{
    protected SimpleKnightEngine engine;
    public Scene(SimpleKnightEngine engine)
    {
        this.engine = engine;
    }
    public abstract void drawScene(Graphics g);
}
