package Core;

import Rendering.FrameState;

import java.awt.*;

public class Settings
{
    public static final FrameState frameState = FrameState.WINDOWED;
    public static final Rectangle windowSize = new Rectangle(1800, 1000);
    public static final Color defaultColour = Color.lightGray;
    public static final String missingTextureSprite = "src/main/resources/MissingTexture.jpg";
    public static final double defaultGridSize = 100;
    public static final boolean renderSprites = false;
    public static final int tickSpeed = 100;
    public static final double scrollSpeed = 1.1;
}
