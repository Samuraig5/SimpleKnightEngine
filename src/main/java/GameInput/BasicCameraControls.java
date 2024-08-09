package GameInput;

import Core.Settings;
import GameSpace.Vector.RenderVector;
import Rendering.SKRenderer.Scene;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class BasicCameraControls extends BasicControls
{
    RenderVector lastMousePosition;
    public BasicCameraControls(Scene scene) {
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
        if (SwingUtilities.isRightMouseButton(e)) {
            recordLastMousePosition(e);
        }
    }

    public void recordLastMousePosition(MouseEvent e)
    {
        lastMousePosition = RenderVector.create(e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            deleteLastMousePosition(e);
        }
    }
    public void deleteLastMousePosition(MouseEvent e)
    {
        lastMousePosition = null;
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

    @Override
    public void mouseDragged(MouseEvent e) {
        RenderVector currentMousePosition = RenderVector.create(e.getPoint());

        // Calculate the movement delta
        int deltaX = currentMousePosition.x() - lastMousePosition.x();
        int deltaY = currentMousePosition.y() - lastMousePosition.y();

        RenderVector deltaVector = RenderVector.create(deltaX, deltaY, 0);

        // Update camera offset
        scene.changeCameraOffset(deltaVector);
        System.out.println("Dragging");

        // Update last mouse position
        lastMousePosition = currentMousePosition;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
