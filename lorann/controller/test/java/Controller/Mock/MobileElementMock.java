package Controller.Mock;

import contract.*;

/**
 * Created by Romain on 20/06/2016.
 */
public class MobileElementMock extends ElementMock implements IMobileElement {
    int y;
    int x;
    ControllerOrder direction;
    StateElement stateElement;

    public MobileElementMock(Permeability penetrable, StateElement collectable) {
        super(penetrable, collectable);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setDirection(ControllerOrder direction) {
        this.direction = direction;
    }

    public ControllerOrder getDirection() {
        return direction;
    }

    public ISprite getSprite() {
        return null;
    }

    public StateElement getStateElement() {
        return stateElement;
    }

    public void setStateElement(StateElement stateElement) {
        this.stateElement = stateElement;
    }
}
