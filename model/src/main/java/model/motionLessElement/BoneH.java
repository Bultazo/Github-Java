package model.motionLessElement;

import contract.StateElement;
import contract.Permeability;
import model.Element.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


/**
 * @author DELL
 *
 */
public class BoneH extends MotionlessElement{
	
     /**
     * The main constructor 
     */
    public BoneH() throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/horizontal_bone.png")))), 
        		Permeability.BLOCKING,StateElement.FIXED);

    }

}
