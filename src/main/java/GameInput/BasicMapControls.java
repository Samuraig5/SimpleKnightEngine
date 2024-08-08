package GameInput;

import Core.Settings;
import Rendering.SKRenderer.Scene;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class BasicMapControls extends BasicControls
{


    public BasicMapControls(Scene scene) {
        super(scene);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        changeZoom(e);
    }

    protected void changeZoom(MouseWheelEvent e)
    {
        double zoom = scene.getZoomLevel();
        if (e.getWheelRotation() > 0)
        {
            zoom /= Settings.scrollSpeed;
        }
        else if (e.getWheelRotation() < 0)
        {
            zoom *= Settings.scrollSpeed;
        }
        scene.setZoomLevel(zoom);
    }
}
