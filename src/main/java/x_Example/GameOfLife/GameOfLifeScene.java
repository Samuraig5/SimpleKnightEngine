package x_Example.GameOfLife;

import Core.Settings;
import Core.SimpleKnightEngine;
import GameInput.BasicCameraControls;
import GameSpace.Cell;
import GameSpace.GridSpace;
import GameSpace.Vector.GridBoundVector;
import GameSpace.Vector.GridVector;
import MathHelper.Randoms;
import Objects.GameObject;
import Objects.GridObject;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;
import Rendering.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameOfLifeScene extends Scene
{
    private GridSpace grid;
    public GameOfLifeScene(SimpleKnightEngine engine)
    {
        super(engine);
        GridVector gridSize = new GridVector();
        gridSize.set(100,100);
        grid = new GridSpace(gridSize);
        addRenderable(grid);

        Cell[][][] cells = grid.getCells();
        GridVector size = grid.getSize();

        for (int i = 0; i < size.x(); i++) {
            for (int j = 0; j < size.y(); j++) {
                if (Randoms.decider(0.075f))
                {
                    GridBoundVector gridPos = GridBoundVector.create(grid,i,j,0);
                    setAlive(gridPos, grid);
                }
            }
        }

        controls = new BasicCameraControls(this);
    }

    @Override
    public void drawScene(Graphics g)
    {
        drawRenderables(g);
    }

    @Override
    public void updateScene()
    {
        updateUpdateables();

        GridSpace newGrid = grid.copy();

        for (int i = 0; i < grid.getSize().x(); i++) {
            for (int j = 0; j < grid.getSize().y(); j++) {
                GridBoundVector sourcePos = GridBoundVector.create(grid,i,j,0);
                Cell source = grid.getCells()[sourcePos.x()][sourcePos.y()][0];

                int count = numOfLivingNeigbours(source);

                if (!isAlive(source))
                {
                    if (count == 3)
                    {
                        setAlive(sourcePos, newGrid);
                    }
                }
                else
                {
                    if (count > 3 || count < 2)
                    {
                        setDead(sourcePos, newGrid);
                    }
                }
            }
        }

        grid = newGrid;
    }

    private void setAlive(GridBoundVector gridPos, GridSpace newGrid)
    {
        Image img = engine.getImageManager().getResource("src/main/java/x_Example/GameOfLife/Block.png");
        Sprite sprite = new Sprite(img, true);
        MapIcon mapIcon = new MapIcon(sprite,'?',Color.lightGray);

        GameObject gameObject = new GridObject(newGrid, this, mapIcon, gridPos);
        addGameObject(gameObject);
    }

    private void setDead(GridBoundVector gridPos, GridSpace newGrid)
    {
        List<GameObject> safeObjects = new ArrayList<>(newGrid.getCells()[gridPos.x()][gridPos.y()][0].gameObjects);
        for (GameObject gameObject : safeObjects) {
            gameObject.delete("Died");
        }
    }

    private int numOfLivingNeigbours(Cell source)
    {
        Cell[][][] neighbours = grid.getNeighbours(source);

        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {continue;}
                if (isAlive(neighbours[i][j][1]))
                {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isAlive(Cell cell)
    {
        if (cell == null) {return false;}
        return cell.gameObjects.size() > 0;
    }
}
