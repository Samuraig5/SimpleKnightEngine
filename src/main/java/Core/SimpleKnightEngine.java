package Core;

import Objects.GameClock;
import Rendering.ResourceManager.ImageManager;
import Rendering.ResourceManager.ResourceManager;
import Rendering.SKRenderer.SKRenderer;
import Rendering.SKRenderer.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public abstract class SimpleKnightEngine
{
    /**
     * Logger used for logging
     */
    private static final Logger logger = LoggerFactory.getLogger(SimpleKnightEngine.class);
    /**
     * The window the program runs in
     */
    protected final JFrame frame;
    /**
     * The main rendering class
     */
    protected final SKRenderer renderer;
    /**
     * The clock sending update ticks
     */
    protected final GameClock gameClock;
    /**
     * Manager for images, making sure that a specific image is only loaded once.
     * Helps to cut down on I/O time
     */
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

        gameClock = new GameClock();

        setUp();
    }

    /**
     * Called after the constructor is finished.
     * Scenes should be created and assigned here.
     * When a scene is loaded, the game clock isn't automatically started.
     */
    public abstract void setUp();

    public void setScene(Scene scene)
    {
        renderer.setScene(scene);
        gameClock.setScene(scene);
    }

    /**
     * Returns the imageManager
     * @return the imageManager of the program
     */
    public ImageManager getImageManager() {return imageManager;}

    /**
     * Returns the renderer
     * @return the renderer of the program
     */
    public SKRenderer getRenderer() {return renderer;}

    /**
     * Returns the gameClock
     * @return the gameClock of the program
     */
    public GameClock getGameClock() {return gameClock;}
}
