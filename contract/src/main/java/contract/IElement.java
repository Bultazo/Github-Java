package contract;

/**
 *Interface of the Element.
 *@author Romain
 */
public interface IElement {

    /**
     * Gets the sprite.
     *
     * @return
     *      The sprite.
     */
    ISprite getSprite();

    /**
     * Sets the sprite,
     *
     * @param sprite
     *      The sprite,
     */
    void setSprite(ISprite sprite);

    /**
     * Gets the permeability.
     *
     * @return
     *      The permeability.
     */
    Permeability getPermeability();

    /**
     * Sets the permeability.
     *
     * @param permeability
     *      The permeability.
     */
    void setPermeability(Permeability permeability);

    /**
     * Gets the Element's state.
     *
     * @return
     *      stateElement
     */
    StateElement getStateElement();

    /**
     * Sets the Element's state.
     *
     * @param stateElement
     *      The state of the element.
     */
    void setStateElement(StateElement stateElement);

}




