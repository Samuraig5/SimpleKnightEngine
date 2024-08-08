package GameInput;

import MathHelper.Basics;
import Rendering.SKRenderer.Scene;

public abstract class BasicControls implements MenuControls
{
    protected Scene scene;

    public BasicControls(Scene scene)
    {
        this.scene = scene;
    }
}
