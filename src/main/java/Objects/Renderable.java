package Objects;

import Rendering.SKRenderer.Scene;

import java.awt.*;

public interface Renderable
{
    /**
     * Call to render the object.
     * This call is order sensitive.
     * Ie if two objects occupy the same space or overlap,
     * the object that is rendered later will be drawn on top of the object that was rendered first.
     * Renderables should be sorted by the render priority (getRenderPriority();) first.
     * @param g Graphics used to render the window
     * @param scene Scene to render the object to
     */
    void render(Graphics g, Scene scene);

    /**
     * Setter for the RenderPriority.
     * A higher number should have priority over a lower.
     * Ie an object with a higher priority should be drawn over other objects with a lower priority.
     * Default priority is 0.
     * @param priority int representing the render priority of the object.
     */
    void setRenderPriority(int priority);

    /**
     * Getter for the RenderPriority.
     * A higher number should have priority over a lower.
     * Ie an object with a higher priority should be drawn over other objects with a lower priority.
     * Default priority is 0.
     * @return int representing the render priority of the object.
     */
    int getRenderPriority();
}
