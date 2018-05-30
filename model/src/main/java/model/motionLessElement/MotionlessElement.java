package model.motionLessElement;

import contract.StateElement;

import contract.Permeability;
import model.Element.*;


public abstract class MotionlessElement extends Element{

    MotionlessElement(Sprite sprite, Permeability permeability, StateElement stateElement){
        super(sprite,permeability,stateElement);
    }


}
