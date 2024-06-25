package Rendering;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class SKRenderer extends JPanel implements ImageObserver
{
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
    }
}
