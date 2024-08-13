package x_Example.BouncyGame;

import Core.SimpleKnightEngine;

public class BouncyGameEngine extends SimpleKnightEngine
{
    public BouncyGameEngine(String programName) {
        super(programName);
    }

    @Override
    public void setUp() {
        setScene(new BouncyGameScene(this));
        gameClock.startClock();
    }
}
