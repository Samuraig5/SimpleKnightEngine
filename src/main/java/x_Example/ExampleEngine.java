package x_Example;

import Core.SimpleKnightEngine;
import Rendering.ResourceManager.ImageManager;
import Rendering.SKRenderer.Scene;

public class ExampleEngine extends SimpleKnightEngine
{

    public ExampleEngine(String programName) {
        super(programName);
    }

    @Override
    public void setUp()
    {
        Scene exampleScene = new ExampleScene(this);
        renderer.setScene(exampleScene);
        gameClock.setScene(exampleScene);
        gameClock.startClock();
    }
}
