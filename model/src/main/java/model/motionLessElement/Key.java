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
public class Key extends MotionlessElement{
   
    /**
     * The main constructor 
     */
    public Key() throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/crystal_ball.png")))), 
        		Permeability.PENETRABLE,StateElement.COLLECTABLE);
    }


}
