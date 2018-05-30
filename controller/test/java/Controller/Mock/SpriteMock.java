package Controller.Mock;

import contract.ISprite;

import java.awt.*;

/**
 * Created by Romain on 20/06/2016.
 */
public class SpriteMock implements ISprite{

    Image image;
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
