package x_Example.SolarSystem;

import Core.SimpleKnightEngine;
import GameInput.BasicCameraControls;
import GameSpace.Vector.IntegerVector;
import GameSpace.Vector.RenderVector;
import Rendering.MapIcon;
import Rendering.SKRenderer.Scene;
import Rendering.Sprite;

import java.awt.*;

public class SolarSystemScene extends Scene
{
    public SolarSystemScene(SimpleKnightEngine engine) {
        super(engine);

        Image sunImage = engine.getImageManager().getResource("src/main/java/x_Example/SolarSystem/sun.png");
        Sprite sunSprite = new Sprite(sunImage, false);
        MapIcon sunIcon = new MapIcon(sunSprite, 'o' ,Color.yellow, 1000);
        SolarObject sun = new SolarObject(this, sunIcon, IntegerVector.create(100,100,0));
        addGameObject(sun);

        Image planetImage = engine.getImageManager().getResource("src/main/java/x_Example/SolarSystem/sun.png");
        Sprite planetSprite = new Sprite(planetImage, false);
        MapIcon planetIcon = new MapIcon(planetSprite, 'o' ,Color.black, 100);
        SolarObject planet1 = new SolarObject(this, planetIcon, IntegerVector.create(1000,1000,0));
        planet1.setParent(sun, 600, 0.01);
        addGameObject(planet1);

        SolarObject planet2 = new SolarObject(this, planetIcon, IntegerVector.create(1000,1000,0));
        planet2.setParent(sun, 800, 0.005);
        addGameObject(planet2);

        controls = new BasicCameraControls(this);
    }

    @Override
    public void drawScene(Graphics g) {
        drawRenderables(g);
    }

    @Override
    public void updateScene() {
        updateUpdateables();
    }
}
