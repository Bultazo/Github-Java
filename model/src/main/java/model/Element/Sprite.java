package model.Element;

import contract.ISprite;

import java.awt.*;

/**
 * @author DELL
 *
 */
public class Sprite implements ISprite{

    /**
     * The image
     */
    private Image image;

    /**
     * The main constructor 
     */
    public Sprite(Image image) {
        this.image = image;
    }

  
    /*
     * Overrides the getImage Method in the implemented interface
     */ 
    public Image getImage() {
        return image;
    }

    /*
     * Overrides the setImage Method in the implemented interface
     */ 
    public void setImage(Image image) {
        this.image = image;
    }
}
