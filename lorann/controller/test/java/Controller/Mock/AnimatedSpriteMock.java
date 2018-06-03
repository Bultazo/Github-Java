package Controller.Mock;

import contract.IAnimatedSprite;

import java.awt.*;

/**
 * Created by Romain on 20/06/2016.
 */
public class AnimatedSpriteMock implements IAnimatedSprite {
    int step;
    Image[] images;

    public void next() {
        this.step++;
        if(this.step >= this.images.length){
            this.step = 0;
        }
        setImage(images[step]);
    }

    public Image getImage() {
        return this.images[this.step];
    }

    public void setImage(Image image) {
        this.images = images;
    }
}
