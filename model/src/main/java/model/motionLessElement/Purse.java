package model.motionLessElement;

import contract.StateElement;

import contract.Permeability;
import model.Element.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Purse extends MotionlessElement{
    
    public Purse() throws IOException {
        super((new Sprite(ImageIO.read(new File("C:/Users/DELL/eclipse-workspace/Lorann-master/Lorann-master/model/sprite/purse.png")))), Permeability.PENETRABLE,StateElement.COLLECTABLE);
    }

}
