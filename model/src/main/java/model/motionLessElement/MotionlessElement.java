package model.motionLessElement;

import contract.StateElement;

import contract.Permeability;
import model.Element.*;


/**
 * @author DELL
 *
 */
public abstract class MotionlessElement extends Element{

    /**
     * The main constructor 
     */
    MotionlessElement(Sprite sprite, Permeability permeability, StateElement stateElement){
        super(sprite,permeability,stateElement);
    }


}
