package Objects;

import Core.Settings;
import GameSpace.Vector.Vector;
import GameSpace.Vector.FreeVector;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;

import java.awt.*;

public class GameObject implements Updatable, Renderable
{
    /**
     * Scene the GameObject is in
     */
    protected final Scene scene;
    /**
     * Position of the GameObject
     */
    private final Vector<?> position;
    /**
     * MapIcon of the GameObject.
     * The Sprite or Icon of the MapIcon is used to render the object.
     */
    protected final MapIcon mapIcon;

    public GameObject(Scene scene, MapIcon mapIcon, Vector<?> position)
    {
        this.scene = scene;
        this.mapIcon = mapIcon;
        this.position = position;
        setPosition(position);
    }

    /**
     * Set the GameObject's position to the new position
     * @param newPosition new position for the GameObject
     */
    public void setPosition(Vector<?> newPosition)
    {
        position.copy(newPosition);
    }

    /**
     * @return current position of the GameObject
     */
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
