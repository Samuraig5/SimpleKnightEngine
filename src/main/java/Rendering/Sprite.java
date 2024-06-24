package Rendering;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Sprite {
    private Image image;
    private boolean fullCover;

    public Sprite(Image image, boolean fullCover)
    {
        setImage(image);
        setFullCover(fullCover);
    }

    public Sprite(String addr, boolean fullCover) throws IOException {
        setImage(addr);
        setFullCover(fullCover);
    }

    public Sprite(Sprite source) {
        setImage(source.getImage());
        setFullCover(source.isFullCover());
    }

    public void setImage(String addr) throws IOException {
        try {
            this.image = ImageIO.read(new File(addr));
        } catch (IOException e) {
            System.err.println("Unable to load '" + addr + "' from files!");
            throw e; // Propagate the exception to the caller if needed
        }
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setFullCover(boolean cover) {
        fullCover = cover;
    }

    public boolean isFullCover() {
        return fullCover;
    }
}
