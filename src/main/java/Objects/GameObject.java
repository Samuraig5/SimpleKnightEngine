package Objects;

import Core.Settings;
import GameSpace.Vector.Vector;
import GameSpace.Vector.FreeVector;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;

import java.awt.*;

public class GameObject implements Updatable, Renderable
{
    protected final Vector<?> vector;
    protected final MapIcon mapIcon;

    public GameObject(MapIcon mapIcon, Vector<?> vector)
    {
        this.mapIcon = mapIcon;
        this.vector = vector;
    }

    @Override
    public void render(Graphics g, Scene scene)
    {
        if (!mapIcon.hasSprite()) {return;}
        Image img = mapIcon.getSprite().getImage();
        FreeVector renderCoords = vector.getRenderCoordinates();

        double zoom = scene.getEngine().getRenderer().getZoomLevel();
        int gridSize = (int) Math.floor(Settings.defaultGridSize * zoom);

        int x = (int) Math.round(renderCoords.x()*zoom);
        int y = (int) Math.round(renderCoords.y()*zoom);

        g.drawImage(img, x, y, gridSize, gridSize, scene.getEngine().getRenderer());    }

    @Override
    public void update() {

    }
}
