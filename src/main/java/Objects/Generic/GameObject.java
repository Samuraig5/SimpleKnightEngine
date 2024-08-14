package Objects.Generic;

import Core.Settings;
import GameSpace.Vector.RenderVector;
import GameSpace.Vector.Vector;
import Rendering.ColouredString;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;

import java.awt.*;

public abstract class GameObject implements Updatable, Renderable, Deletable
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
    private int renderPriority;

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
    public RenderVector getRenderCoordinates() {return position.getRenderCoordinates(scene.getZoomLevel());}

    protected void drawObject(Graphics g, RenderVector renderCoords, int renderSize)
    {
        if (mapIcon.hasSprite() && Settings.renderSprites)
        {
            Image img = mapIcon.getSprite().getImage();
            g.drawImage(img, renderCoords.x(), renderCoords.y(),
                    renderSize, renderSize,
                    scene.getEngine().getRenderer());
        }
        else
        {
            char c = mapIcon.getSymbol();
            Color color = mapIcon.getIconColour();
            ColouredString colouredString = new ColouredString(c+"",color);

            g.setColor(colouredString.getColor());
            g.setFont(new Font("Courier New", Font.PLAIN, renderSize));

            g.drawString(colouredString.getString(), renderCoords.x(), renderCoords.y());
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete(String deleteMessage) {
        scene.removeGameObject(this);
    }

    @Override
    public void setRenderPriority(int priority) {
        this.renderPriority = priority;
    }

    @Override
    public int getRenderPriority() {
        return renderPriority;
    }
}
