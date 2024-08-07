package Objects;

import Core.Settings;
import GameSpace.Vector.Vector;
import GameSpace.Vector.FreeVector;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;

import java.awt.*;

public class GameObject implements Updatable, Renderable
{
    protected final Scene scene;
    private final Vector<?> position;
    protected final MapIcon mapIcon;

    public GameObject(Scene scene, MapIcon mapIcon, Vector<?> position)
    {
        this.scene = scene;
        this.mapIcon = mapIcon;
        this.position = position;
        setPosition(position);
    }

    public void setPosition(Vector<?> newPosition)
    {
        position.copy(newPosition);
    }
    public Vector<?> getPosition() {
        return position;
    }

    @Override
    public void render(Graphics g, Scene scene)
    {
        if (!mapIcon.hasSprite()) {return;}
        Image img = mapIcon.getSprite().getImage();
        FreeVector renderCoords = position.getRenderCoordinates();

        double zoom = scene.getEngine().getRenderer().getZoomLevel();
        int gridSize = (int) Math.floor(Settings.defaultGridSize * zoom);

        int x = (int) Math.round(renderCoords.x()*zoom);
        int y = (int) Math.round(renderCoords.y()*zoom);

        g.drawImage(img, x, y, gridSize, gridSize, scene.getEngine().getRenderer());    }

    @Override
    public void update() {

    }
}
