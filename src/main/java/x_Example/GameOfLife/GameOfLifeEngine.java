package x_Example.GameOfLife;

import Core.SimpleKnightEngine;
import Rendering.SKRenderer.Scene;

public class GameOfLifeEngine extends SimpleKnightEngine
{

    public GameOfLifeEngine(String programName) {
        super(programName);
    }

    @Override
    public void setUp()
    {
        Scene exampleScene = new GameOfLifeScene(this);
        renderer.setScene(exampleScene);
        gameClock.setScene(exampleScene);
        gameClock.startClock();
    }
}
