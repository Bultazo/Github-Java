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
public class BoneV extends MotionlessElement{
    /**
     * The main constructor 
     * @throws IOException
     * 		Can't read file
     */
    public BoneV() throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/vertical_bone.png")))), 
        		Permeability.BLOCKING,StateElement.FIXED);
    }


}
