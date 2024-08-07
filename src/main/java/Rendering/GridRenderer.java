package Rendering;

import Core.Settings;
import GameSpace.Coordinates;
import GameSpace.GridSpace;
import Rendering.SKRenderer.Scene;

import java.awt.*;

public class GridRenderer
{
    public static void drawGrid(Graphics g, Scene scene, GridSpace grid)
    {
        int x = (int) grid.getSize().x();
        int y = (int) grid.getSize().y();

        double zoom = scene.getEngine().getRenderer().getZoomLevel();
        int gridSize = (int) Math.floor(Settings.defaultGridSize * zoom);

        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                g.drawRect(i*gridSize,j*gridSize,gridSize,gridSize);
            }
        }
    }
}
