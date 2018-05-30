package model.Element;

import contract.ISprite;

import java.awt.*;

public class Sprite implements ISprite{

    private Image image;

    public Sprite(Image image) {
        this.image = image;
    }

  
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
