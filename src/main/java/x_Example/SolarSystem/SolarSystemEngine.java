package x_Example.SolarSystem;

import Core.SimpleKnightEngine;

public class SolarSystemEngine extends SimpleKnightEngine
{
    public SolarSystemEngine(String programName) {
        super(programName);
    }

    @Override
    public void setUp() {
        setScene(new SolarSystemScene(this));
        gameClock.startClock();
    }
}
