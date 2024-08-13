package Objects.Generic;

import Core.Settings;
import Rendering.SKRenderer.Scene;

import java.util.Timer;
import java.util.TimerTask;

public class GameClock extends TimerTask
{
    /**
     * Boolean flag.
     * If true, the clock is running and updating the scene.
     * If false, the clock is paused and no objects are updated (but rendering is still being updated)
     */
    private boolean isClockRunning = false;
    /**
     * Holds the current active scene.
     */
    private Scene activeScene;

    public GameClock()
    {
        java.util.Timer timer = new Timer();
        timer.schedule(this, 0, Settings.tickSpeed);
    }

    /**
     * Main update loop. Will skip if the clock is paused or no active scene is set.
     * Otherwise, calls updateScene() of the active scene.
     */
    public void run()
    {
        if (activeScene == null) {return;}
        if (!isClockRunning) {return;}
        activeScene.updateScene();
    }

    /**
     * Sets isClockRunning to true
     */
    public void startClock()
    {
        isClockRunning = true;
    }

    /**
     * Sets isClockRunning to false
     */
    public void stopClock()
    {
        isClockRunning = false;
    }

    /**
     * Toggles isClockRunning. If It's true, it becomes false. If It's false, it becomes true.
     */
    public void toggleClock() {isClockRunning = !isClockRunning;}

    /**
     * @return value of isClockRunning
     */
    public boolean isClockRunning() {return isClockRunning;}

    /**
     * @return currently active scene
     */
    public Scene getScene() {return activeScene;}

    /**
     * Set a new scene as the active scene.
     * @param activeScene new scene to be set active
     */
    public void setScene(Scene activeScene) {this.activeScene = activeScene;}
}
