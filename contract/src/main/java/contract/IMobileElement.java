package contract;

/**
 * Interface of MobileElement.
 * @author Romain
 */
public interface IMobileElement {

    /**
     * Gets the northing.
     * @return
     *      int
     */
    int getY();

    /**
     * Sets the northing.
     * @param y
     *       Northing.
     */
    void setY(int y);

    /**
     * Gets the easting.
     * @return
     *      int
     */
    int getX();

    /**
     *Sets the easting.
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

}
