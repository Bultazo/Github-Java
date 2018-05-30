package model.mobileElement;

import contract.*;
import model.Element.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Spell extends MobileElement {

    public Spell(String path, ControllerOrder direction) throws IOException {
        super((new Sprite(ImageIO.read(new File("C:/Users/DELL/eclipse-workspace/Lorann-master/Lorann-master/model/sprite/fireball_1.png")))), Permeability.PENETRABLE, StateElement.SPELL);
        this.setDirection(direction);
    }

}