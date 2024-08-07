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

        FreeVector randomMovement = new FreeVector();
        randomMovement.randomize(-5,5);
        vector.add(randomMovement);
    }
}
