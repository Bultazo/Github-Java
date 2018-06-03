package model;

import contract.ControllerOrder;
import contract.StateElement;

public interface IMobileElement {

    /**
     * Gets the Y.
     * @return
     *      int
     */
    int getY();

    /**
     * Sets the Y.
     * @param y
     *       Northing.
     */
    void setY(int y);

    /**
     * Gets the X.
     * @return
     *      int
     */
    int getX();

    /**
     *Sets the X.
     * @param x
     *      Easting.
     */
    void setX(int x);

    /**
     * Sets the direction.
     *
     * @param direction
     *      The direction.
     */
    void setDirection (ControllerOrder direction);

    /**
     * Gets the direction.
     *
     * @return
     *       Direction.
     */
    ControllerOrder getDirection();

    /**
     * Gets the sprite.
     * @return
     *      Sprite.
     */
    ISprite getSprite();

    /**
     * Gets the state of an element.
     *
     * @return
     *      stateElement.
     */
    StateElement getStateElement();

    /**
     * Sets the state of the element.
     *
     * @param stateElement
     *      The state.
     */
    void setStateElement(StateElement stateElement);


    /**
     * Moves Left
     *
     */
    public void moveLeft();
    
    /**
     * Moves Right
     *
     */
    public void moveRight();
    
    /**
     * Moves Up
     * 
     */
    public void moveUp();
    
    /**
     * Moves Down
     *
     */
    public void moveDown();
    
	/**
	 * Moves DownLeft
	 */
	public void moveDownLeft();
	
	/**
	 * Moves DownRight
	 */
	public void moveDownRight();
	
	/**
	 * Moves UpLeft
	 */
	public void moveUpLeft();
	
	/**
	 * Moves UpRight
	 */
	public void moveUpRight();
}
