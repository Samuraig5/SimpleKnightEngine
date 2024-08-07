package x_Example.BrownianSoup;

import GameSpace.GridSpace;
import GameSpace.Vector.GridBoundVector;
import GameSpace.Vector.GridVector;
import GameSpace.Vector.Vector;
import Objects.GameObject;
import Objects.GridObject;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;

public class BrownianMovement extends GridObject
{
    public BrownianMovement(GridSpace gridSpace, Scene scene, MapIcon mapIcon, Vector<?> vector)
    {
        super(gridSpace, scene, mapIcon, vector);
    }

    @Override
    public void update()
    {
        super.update();

        GridVector randomMovement = new GridVector();
        randomMovement.randomize(-1,1);
        Vector<?> position = getPosition();
        position.add(randomMovement);
        setPosition(position);

        if (myCell.gameObjects.size() < 2)
        {
            GridBoundVector gridPos = new GridBoundVector(gridSpace);
            gridPos.copy(position);
            GameObject gameObject = new Marker(gridSpace, scene, mapIcon, gridPos);
            scene.addGameObject(gameObject);
        }
    }
}
