package x_Example;

import GameSpace.Vector.FreeVector;
import GameSpace.Vector.GridVector;
import GameSpace.Vector.Vector;
import Objects.GameObject;
import Rendering.MapIcon;

public class BrownianMovement extends GameObject
{
    public BrownianMovement(MapIcon mapIcon, Vector<?> vector)
    {
        super(mapIcon, vector);
    }

    @Override
    public void update()
    {
        super.update();

        GridVector randomMovement = new GridVector();
        randomMovement.randomize(-1,1);
        vector.add(randomMovement);
    }
}
