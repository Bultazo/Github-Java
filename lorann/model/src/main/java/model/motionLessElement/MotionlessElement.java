package model.motionLessElement;

import contract.StateElement;

import java.io.IOException;

import contract.Permeability;
import model.Element.*;


/**
 * @author DELL
 *
 */
public abstract class MotionlessElement extends Element{

    /**
     * The main constructor 
     * @throws IOException
     * 		Can't read file
     */
    MotionlessElement(Sprite sprite, Permeability permeability, StateElement stateElement){
        super(sprite,permeability,stateElement);
    }


}
