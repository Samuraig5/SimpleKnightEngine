package x_Example.BrownianSoup;

import Core.SimpleKnightEngine;
import Rendering.SKRenderer.Scene;

public class BrownianSoupEngine extends SimpleKnightEngine
{

    public BrownianSoupEngine(String programName) {
        super(programName);
    }

    @Override
    public void setUp()
    {
        Scene exampleScene = new BrownianSoupScene(this);
        setScene(exampleScene);
        gameClock.startClock();
    }
}
