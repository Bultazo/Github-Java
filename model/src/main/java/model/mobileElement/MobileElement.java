package model.mobileElement;
import model.IMobileElement;

import model.Model;
import model.Element.*;
import contract.*;



/**
 * @author DELL
 *
 */
public class MobileElement extends Element implements IMobileElement{
	
    /**
     * The x
     */
    private int x;

    /**
     * The y
     */
    private int y;

    /**
     * The sprite
     */
    private Sprite sprite;
         
    /**
     * The permeability
     */
    private Permeability permeability;

    /**
     * The stateElement
     */
    private StateElement stateElement;
  
    /**
     * The direction
     */
    private ControllerOrder direction;
    
    /**
     * The model
     */
    protected Model model;

    /**
     * The main constructor 
     */
    public MobileElement(Sprite sprite, Permeability permeability, StateElement stateElement) {
        super(sprite,permeability,stateElement);
    }

    
    /**
     * Sets the sprite of the Element
     * @return void
     */
    public synchronized void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
    
    /*
     * Overrides the getY Method in the implemented interface
     */ 
    public int getY() {
        return y;
    }


    /*
     * Overrides the setY Method in the implemented interface
     */ 
    public void setY(int y) {this.y = y;}


    /*
     * Overrides the getX Method in the implemented interface
     */ 
    public int getX() {return x;}


    /*
     * Overrides the setX Method in the implemented interface
     */ 
    public void setX(int x) {this.x = x;}


    /*
     * Overrides the getPermeability Method in the implemented interface
     */ 
    public Permeability getPermeability() {
        return permeability;
    }

 
    /*
     * Overrides the setDirection Method in the implemented interface
     */ 
    public void setDirection(ControllerOrder direction){
        this.direction = direction;
    }

     
    /*
     * Overrides the getDirection Method in the implemented interface
     */ 
    public ControllerOrder getDirection() {
        return direction;
    }

     
    /*
     * Overrides the setPermeability Method in the implemented interface
     */ 
    public void setPermeability(Permeability permeability) {
        this.permeability = permeability;
    }

     
    /*
     * Overrides the getStateElement Method in the implemented interface
     */ 
    public StateElement getStateElement() {
        return stateElement;
    }

     
    /*
     * Overrides the setStateElement Method in the implemented interface
     */ 
    public void setStateElement(StateElement stateElement) {
        this.stateElement = stateElement;
    }

	/*
	 * Overrides the moveLeft Method in the implemented interface
	 */ 
	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Overrides the moveRight Method in the implemented interface
	 */ 
	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Overrides the moveUp Method in the implemented interface
	 */ 
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Overrides the moveDown Method in the implemented interface
	 */ 
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}


	/*
	 * Overrides the moveDownLeft Method in the implemented interface
	 */ 
	@Override
	public void moveDownLeft() {
		// TODO Auto-generated method stub
		
	}


	/*
	 * Overrides the moveDownRight Method in the implemented interface
	 */ 
	@Override
	public void moveDownRight() {
		// TODO Auto-generated method stub
		
	}


	/*
	 * Overrides the moveUpLeft Method in the implemented interface
	 */ 
	@Override
	public void moveUpLeft() {
		// TODO Auto-generated method stub
		
	}


	/*
	 * Overrides the moveUpRight Method in the implemented interface
	 */ 
	@Override
	public void moveUpRight() {
		// TODO Auto-generated method stub
		
	}
}
