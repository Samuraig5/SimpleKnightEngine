package Rendering;

import Core.Settings;
import java.awt.*;

public class MapIcon
{
    private Sprite sprite;
    private char symbol;
    private Color iconColour;

    private void Initialize(Sprite sprite, char symbol, Color iconColour)
    {
        this.sprite = sprite;
        this.symbol = symbol;
        this.iconColour = iconColour;
    }
    public MapIcon(Sprite sprite, char symbol, Color iconColour) {Initialize(sprite, symbol, iconColour);}
    public MapIcon(char symbol) {Initialize(null, symbol, Settings.defaultColour);}
    public MapIcon() {Initialize(null, '?', Settings.defaultColour);}

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
}
