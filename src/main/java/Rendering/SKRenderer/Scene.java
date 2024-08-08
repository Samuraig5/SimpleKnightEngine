package Rendering.SKRenderer;

import Core.SimpleKnightEngine;
import GameInput.MenuControls;
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
    protected MenuControls controls;
    private final List<Updatable> updatables = new ArrayList<>();
    private final List<Renderable> renderables = new ArrayList<>();
    public Scene(SimpleKnightEngine engine)
    {
        this.engine = engine;
    }
    public SimpleKnightEngine getEngine() {
        return engine;
    }
    public MenuControls getControls() {return controls;}
    public List<Updatable> getUpdatables()
    {
        return new ArrayList<>(updatables);
    }
    public List<Renderable> getRenderables()
    {
        return new ArrayList<>(renderables);
    }
    private double zoomLevel = 1;
    public void addGameObject(GameObject gameObject)
    {
        updatables.add(gameObject);
        renderables.add(gameObject);
    }
    public void removeGameObject(GameObject gameObject)
    {
        updatables.remove(gameObject);
        renderables.remove(gameObject);
    }
    public void drawRenderables(Graphics g)
    {
        for (Renderable renderable:getRenderables())
        {
            if (renderable == null) {continue;}
            renderable.render(g,this);
        }
    }
    protected void updateUpdateables()
    {
        for (Updatable updatable:getUpdatables())
        {
            updatable.update();
        }
    }
    public abstract void drawScene(Graphics g);
    public abstract void updateScene();
    public double getZoomLevel() {
        return zoomLevel;
    }
    public void setZoomLevel(double zoomLevel) {
        this.zoomLevel = zoomLevel;
    }
}
