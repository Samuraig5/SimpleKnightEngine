package x_Example.SolarSystem;

import GameSpace.Vector.FreeVector;
import GameSpace.Vector.Vector;
import Objects.FreeObject;
import Objects.GameObject;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;

public class SolarObject extends FreeObject {

    private SolarObject parent;
    private double distance;
    private double angle;  // Current angle of the orbit in radians
    private double angularVelocity;  // How fast the object orbits (radians per tick)

    public SolarObject(Scene scene, MapIcon mapIcon, Vector<?> position)
    {
        super(scene, mapIcon, position);
    }

    public void setParent(SolarObject parent, double distance, double angularVelocity) {
        this.parent = parent;
        this.distance = distance;
        this.angularVelocity = angularVelocity;
    }

    @Override
    public void update() {
        super.update();
        if (parent != null)
        {
            // Increment the angle based on angular velocity
            angle += angularVelocity;

            // Calculate the new position in 2D space (assuming x-y plane)
            FreeVector position = FreeVector.create(0,0,0);
            position.add(parent.getPosition());

            FreeVector orbitalOffset = FreeVector.create(distance * Math.cos(angle),distance * Math.sin(angle), 0 );
            position.add(orbitalOffset);

            // Update the position of the SolarObject
            setPosition(position);
        }
    }
}
