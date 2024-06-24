package Rendering;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Renderer extends JPanel implements ImageObserver
{
    public Renderer()
    {

    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        repaint();
        revalidate();
    }
}
