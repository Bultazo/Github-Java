package model.mobileElement;

import contract.*;
import model.Element.*;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Hero extends MobileElement implements IAnimatedSprite {
    private AnimatedSprite sprites;

    public Hero() throws IOException {
       
    	super(new Sprite(ImageIO.read(new File("sprite/lorann_r.png"))), Permeability.BLOCKING, StateElement.NOP);
       
    	String Animation[] = {
            "lorann_b",
            "lorann_bl",
            "lorann_l",
            "lorann_ul",
            "lorann_u",
            "lorann_ur",
            "lorann_r",
            "lorann_br",
        };

        sprites = new AnimatedSprite((ImageIO.read(new File("sprite/lorann_b.png"))),Animation);
    }


    public void next() {
        sprites.next();
        setImage(sprites.getImage());
    }


    public Image getImage() {
        return sprites.getImage();
    }


    public void setImage(Image image) {
        this.getSprite().setImage(image);
    }
}
