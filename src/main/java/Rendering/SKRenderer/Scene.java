package Rendering.SKRenderer;

import Core.SimpleKnightEngine;
import Objects.GameObject;
import Objects.Renderable;
import Objects.Updatable;
import ch.qos.logback.core.pattern.LiteralConverter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Scene
{
    protected SimpleKnightEngine engine;
    public List<Updatable> updatables = new ArrayList<>();
    public List<Renderable> renderables = new ArrayList<>();

    public Scene(SimpleKnightEngine engine)
    {
        this.engine = engine;
    }
    public SimpleKnightEngine getEngine() {
        return engine;
    }
    public void drawRenderables(Graphics g)
    {
        List<Renderable> safeRenderables = new ArrayList<>(renderables);
        for (Renderable renderable:safeRenderables)
        {
            renderable.render(g,this);
        }
    }
    protected void updateUpdateables()
    {
        List<Updatable> safeUpdatables = new ArrayList<>(updatables);
        for (Updatable updatable:safeUpdatables)
        {
            updatable.update();
        }
    }
    public abstract void drawScene(Graphics g);
    public abstract void updateScene();
}
