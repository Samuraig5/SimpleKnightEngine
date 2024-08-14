package Objects.FreeObject;

import GameSpace.Vector.IntegerVector;
import GameSpace.Vector.RenderVector;
import Objects.Generic.GameObject;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;

import java.awt.*;

public class FreeObject extends GameObject
{
    public FreeObject(Scene scene, MapIcon mapIcon, IntegerVector position) {
        super(scene, mapIcon, position);
    }

    @Override
    public void render(Graphics g, Scene scene) {
        RenderVector renderCoords = getPosition().getRenderCoordinates(scene.getZoomLevel());
        int renderSize = (int) Math.round(mapIcon.getIconSize() * scene.getZoomLevel());
        RenderVector objectOffset = RenderVector.create(-renderSize/2,-renderSize/2);
        renderCoords.add(objectOffset);

        drawObject(g, renderCoords, renderSize);
    }
}
