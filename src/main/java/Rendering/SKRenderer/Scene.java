package Rendering.SKRenderer;

import Core.SimpleKnightEngine;
import GameInput.MenuControls;
import GameSpace.Vector.RenderVector;
import Objects.Generic.Collidable;
import Objects.Generic.GameObject;
import Objects.Generic.Renderable;
import Objects.Generic.Updatable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public abstract class Scene
{
    protected SimpleKnightEngine engine;
    protected MenuControls controls;
    private final List<Updatable> updatables = new ArrayList<>();
    private final List<Renderable> renderables = new ArrayList<>();
    private final List<Collidable> collidables = new ArrayList<>();

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
    public void addUpdatable(Updatable updatable) {updatables.add(updatable);}
    public List<Renderable> getRenderables()
    {
        return new ArrayList<>(renderables);
    }
    public void addRenderable(Renderable renderable) {renderables.add(renderable);}
    public void addCollidable(Collidable collidable) {collidables.add(collidable);}
    public List<Collidable> getCollidables() {return new ArrayList<>(collidables);}

    private double zoomLevel = 1;
    private RenderVector cameraOffset = RenderVector.create(0,0,0);
    public void addGameObject(GameObject gameObject)
    {
        updatables.add(gameObject);
        renderables.add(gameObject);
        if (gameObject instanceof Collidable)
        {
            collidables.add((Collidable) gameObject);
        }
    }
    public void removeGameObject(GameObject gameObject)
    {
        updatables.remove(gameObject);
        renderables.remove(gameObject);
        if (gameObject instanceof Collidable)
        {
            collidables.remove((Collidable) gameObject);
        }
    }
    public void drawRenderables(Graphics g)
    {
        List<Renderable> saveRenderables = getRenderables();

        saveRenderables.removeIf(Objects::isNull);

        if (saveRenderables.size() > 1)
        {
            saveRenderables.sort(Comparator.comparingInt(Renderable::getRenderPriority));
        }

        for (Renderable renderable:saveRenderables)
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
    public RenderVector getCameraOffset() {return cameraOffset;}
    public void setCameraOffset(RenderVector newOffset) {cameraOffset = newOffset;}
    public void changeCameraOffset(RenderVector change)
    {
        change.scale(1/getZoomLevel());
        cameraOffset.add(change);
    }
    public RenderVector getMouseWorldPosition()
    {
        RenderVector mouse = engine.getMouseScreenPosition();
        mouse.set(mouse.x(), mouse.y(), 0);
        RenderVector offset = new RenderVector();
        offset.copy(cameraOffset);
        offset.set((int) (offset.x()*zoomLevel), (int) (offset.y()*zoomLevel), 0);
        offset.invert();
        mouse.add(offset);
        return mouse;
    }
}
