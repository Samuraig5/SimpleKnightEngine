package Rendering.ResourceManager;

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
        catch (IOException e)
        {
            logger.debug("IOException when trying to open: " + filepath);
            System.err.println("Unable to load '" + filepath + "' from files!");
        }
        return null;
    }
}
