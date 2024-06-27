package Rendering.ResourceManager;

import Core.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageManager extends ResourceManager<Image>
{
    @Override
    protected Image loadResource(String filepath)
    {
        try
        {
            return ImageIO.read(new File(filepath));
        }
        catch (IOException e1)
        {
            if (filepath.equals(Settings.missingTextureSprite))
            {
                logger.error("CRITICAL ERROR: UNABLE TO LOAD 'MISSING TEXTURE'!");
                return null;
            }
            logger.debug("IOException when trying to open: " + filepath + ". Opening 'Missing Texture' instead ");
            return getResource(Settings.missingTextureSprite);
        }
    }
}
