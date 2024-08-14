package x_Example.CollisionDetection;

import Core.SimpleKnightEngine;

public class CollisionDetectionEngine extends SimpleKnightEngine {
    public CollisionDetectionEngine(String programName) {
        super(programName);
    }

    @Override
    public void setUp() {
        setScene(new CollisionDetectionScene(this));
    }
}
