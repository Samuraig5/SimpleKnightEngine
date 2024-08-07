package Objects;

import Core.Settings;
import Rendering.SKRenderer.Scene;

import java.util.Timer;
import java.util.TimerTask;

public class GameClock extends TimerTask
{
    private boolean isClockRunning = false;
    private Scene activeScene;

    public GameClock()
    {
        java.util.Timer timer = new Timer();
        timer.schedule(this, 0, Settings.tickSpeed);
    }

    public void run()
    {
        if (activeScene == null) {return;}
        if (!isClockRunning) {return;}
        activeScene.updateScene();
    }
    public void startClock()
    {
        isClockRunning = true;
    }
    public void stopClock()
    {
        isClockRunning = false;
    }
    public void toggleClock() {isClockRunning = !isClockRunning;}
    public boolean isClockRunning() {return isClockRunning;}
    public Scene getScene() {return activeScene;}
    public void setScene(Scene activeScene) {this.activeScene = activeScene;}
}
