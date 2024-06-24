package Rendering;

import Core.Settings;
import java.awt.*;

public class ColouredString
{
    private String string;
    private Color color;
    private void Initialize(String string, Color color)
    {
        this.string = string;
        this.color = color;
    }
    public ColouredString(String string, Color color) {Initialize(string, color);}
    public ColouredString(String string){Initialize(string, Settings.defaultColour);}

    public void setString(String string) {
        this.string = string;
    }
    public String getString() {
        return string;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return color;
    }
}
