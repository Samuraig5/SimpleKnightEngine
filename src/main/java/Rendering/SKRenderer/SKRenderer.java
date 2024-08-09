package Rendering.SKRenderer;

import Core.SimpleKnightEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;

public class SKRenderer extends JPanel implements ImageObserver
{
    private static final Logger logger = LoggerFactory.getLogger(SKRenderer.class);
    private Scene activeScene;

    public SKRenderer()
    {
        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        repaint();
        revalidate();

        if (activeScene != null)
        {
            paintActiveScene(g);
        }
        else
        {
            logger.debug("No scene is loaded");
        }
    }

    private void paintActiveScene(Graphics g)
    {
        activeScene.drawScene(g);
    }

    public void setScene(Scene s) {
        if (activeScene != null) {
            removeMouseListener(activeScene.getControls());
            removeKeyListener(activeScene.getControls());
            removeMouseWheelListener(activeScene.getControls());
            removeMouseMotionListener(activeScene.getControls());
        }

        activeScene = s;
        logger.debug("Successfully set new scene");

        addMouseListener(activeScene.getControls());
        addKeyListener(activeScene.getControls());
        addMouseWheelListener(activeScene.getControls());
        addMouseMotionListener(activeScene.getControls());
    }
}
