package model.motionLessElement;

import contract.StateElement;
import contract.Permeability;
import model.Element.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BoneC extends MotionlessElement{
    public BoneC() throws IOException {
        super((new Sprite(ImageIO.read(new File("C:/Users/DELL/eclipse-workspace/Lorann-master/Lorann-master/model/sprite/bone.png")))), 
        		Permeability.BLOCKING,StateElement.FIXED);
    }

}
