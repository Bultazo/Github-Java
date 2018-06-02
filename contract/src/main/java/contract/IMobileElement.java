package contract;


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
     * @return void
     */
    public void moveLeft();
    
    /**
     * Moves Right
     * @return void
     */
    public void moveRight();
    
    /**
     * Moves Up
     * @return void
     */
    public void moveUp();
    
    /**
     * Moves Down
     * @return void
     */
    public void moveDown();
}
