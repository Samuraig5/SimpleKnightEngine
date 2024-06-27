package x_Example;

import Core.SimpleKnightEngine;
import Rendering.ResourceManager.ImageManager;

public class ExampleEngine extends SimpleKnightEngine
{

    public ExampleEngine(String programName) {
        super(programName);
    }

    @Override
    public void setUp()
    {
        renderer.setScene(new ExampleScene(this));
    }
}
