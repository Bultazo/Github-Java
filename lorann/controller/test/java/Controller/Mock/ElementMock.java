package Controller.Mock;

import contract.IElement;
import contract.ISprite;
import contract.Permeability;
import contract.StateElement;

/**
 * Created by Romain on 20/06/2016.
 */
public class ElementMock implements IElement {

    ISprite sprite;
    Permeability permeability;
    StateElement stateElement;

    public ElementMock(Permeability penetrable, StateElement collectable) {
    }

    public ISprite getSprite() {
        return this.sprite;
    }

    public void setSprite(ISprite sprite) {
        this.sprite=sprite;
    }

    public Permeability getPermeability() {
        return this.permeability;
    }

    public void setPermeability(Permeability permeability) {
        this.permeability = permeability;
    }

    public StateElement getStateElement() {
        return this.stateElement;
    }

    public void setStateElement(StateElement stateElement) {
        this.stateElement = stateElement;
    }
}
