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
public class Door extends MotionlessElement {
  
    /**
     * The main constructor 
     * @throws IOException
     * 		Can't read file
     */
    public Door() throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/gate_closed.png")))), 
        		Permeability.BLOCKING,StateElement.DRAGON);
    }



}
