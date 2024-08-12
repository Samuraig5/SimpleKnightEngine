package Rendering;

import Core.Settings;
import java.awt.*;

public class MapIcon
{
    private Sprite sprite;
    private char symbol;
    private Color iconColour;
    private int iconSize;

    private void Initialize(Sprite sprite, char symbol, Color iconColour, int iconSize)
    {
        this.sprite = sprite;
        this.symbol = symbol;
        this.iconColour = iconColour;
        this.iconSize = iconSize;
    }
    public MapIcon(Sprite sprite, char symbol, Color iconColour, int iconSize) {Initialize(sprite, symbol, iconColour, iconSize);}
    public MapIcon(Sprite sprite, char symbol, Color iconColour) {Initialize(sprite, symbol, iconColour, (int)Settings.defaultGridSize);}
    public MapIcon(char symbol, Color iconColour, int iconSize) {Initialize(null, symbol, iconColour, iconSize);}
    public MapIcon(char symbol) {Initialize(null, symbol, Settings.defaultColour, (int)Settings.defaultGridSize);}

    public MapIcon() {Initialize(null, '?', Settings.defaultColour, (int)Settings.defaultGridSize);}

    public boolean hasSprite()
    {
        if (sprite == null) {return false;}
        if (sprite.getImage() == null) {return false;}
        else {return true;}
    }
    public void setSprite(Sprite sprite)
    {
        this.sprite = sprite;
    }
    public Sprite getSprite() {return sprite;}
    public void setSymbol(char newSymbol) {symbol = newSymbol;}
    public char getSymbol() {return symbol;}
    public void setIconColour(Color newColour) {iconColour = newColour;}
    public Color getIconColour() {return iconColour;}

    public int getIconSize() {
        return iconSize;
    }

    public void setIconSize(int iconSize) {
        this.iconSize = iconSize;
    }
}
