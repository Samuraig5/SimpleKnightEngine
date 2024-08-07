package Core;

import GameSpace.Coordinates;
import GameSpace.FreeCoordinates;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;

import java.awt.*;

public class GameObject implements Updatable, Rednerable
{
    private final Coordinates<?> coordinates;
    private final MapIcon mapIcon;

    public GameObject(MapIcon mapIcon, Coordinates<?> coordinates)
    {
        this.mapIcon = mapIcon;
        this.coordinates = coordinates;
    }

    @Override
    public void render(Graphics g, Scene scene)
    {
        if (!mapIcon.hasSprite()) {return;}
        Image img = mapIcon.getSprite().getImage();
        FreeCoordinates renderCoords = coordinates.getRenderCoordinates();

        double zoom = scene.getEngine().getRenderer().getZoomLevel();
        int gridSize = (int) Math.floor(Settings.defaultGridSize * zoom);

        int x = (int) Math.round(renderCoords.x()*zoom);
        int y = (int) Math.round(renderCoords.y()*zoom);

        g.drawImage(img, x, y, gridSize, gridSize, scene.getEngine().getRenderer());    }

    @Override
    public void update() {

    }
}
