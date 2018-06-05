package Mock;

import contract.Permeability;
import contract.StateElement;
import model.IElement;
import model.ISprite;


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
