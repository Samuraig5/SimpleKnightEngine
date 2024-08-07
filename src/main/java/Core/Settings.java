package Core;

import Rendering.FrameState;

import java.awt.*;

public class Settings
{
    public static final Color defaultColour = Color.lightGray;
    public static final FrameState frameState = FrameState.WINDOWED;
    public static final Rectangle windowSize = new Rectangle(1800, 1000);
    public static final String missingTextureSprite = "src/main/resources/MissingTexture.jpg";
    public static final double defaultGridSize = 5;
    public static final int tickSpeed = 100;
}
