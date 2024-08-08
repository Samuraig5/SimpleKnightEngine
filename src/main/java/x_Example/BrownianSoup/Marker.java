package x_Example.BrownianSoup;

import GameSpace.GridSpace;
import GameSpace.Vector.Vector;
import Objects.GridObject;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;

public class Marker extends GridObject
{

    public Marker(GridSpace gridSpace, Scene scene, MapIcon mapIcon, Vector<?> vector) {
        super(gridSpace, scene, mapIcon, vector);
    }
}
