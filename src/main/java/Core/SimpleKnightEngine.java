package Core;

import Rendering.ResourceManager.ImageManager;
import Rendering.ResourceManager.ResourceManager;
import Rendering.SKRenderer.SKRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public abstract class SimpleKnightEngine
{
    private static final Logger logger = LoggerFactory.getLogger(SimpleKnightEngine.class);
    protected final JFrame frame;
    protected final SKRenderer renderer;
    protected final ImageManager imageManager = new ImageManager();

    public SimpleKnightEngine(String programName)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Make the window's look match the OS
        }
        catch (Exception e)
        {
            logger.debug("Cant find SystemLookAndFeel");
        }

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Program stops when window is closed

        frame.setTitle(programName);

        switch (Settings.frameState)
        {
            case BORDERLESS_FULLSCREEN:
                frame.setUndecorated(true);
                frame.setExtendedState(Frame.MAXIMIZED_BOTH);
                break;
            case FULLSCREEN:
                frame.setUndecorated(false);
                frame.setExtendedState(Frame.MAXIMIZED_BOTH);
                break;
            case WINDOWED:
                frame.setSize(Settings.windowSize.width, Settings.windowSize.height);
                break;
            default:
                break;
        }

        renderer = new SKRenderer();
        frame.add(renderer);
        renderer.requestFocusInWindow();
        frame.setVisible(true);

        setUp();
    }

    public abstract void setUp();

    public ImageManager getImageManager() {return imageManager;}
    public SKRenderer getRenderer() {return renderer;}
}
