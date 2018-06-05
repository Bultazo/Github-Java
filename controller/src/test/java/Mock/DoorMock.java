package Mock;


import contract.Permeability;
import contract.StateElement;


public class DoorMock extends ElementMock {

    public DoorMock(Permeability penetrable, StateElement collectable) {
        super(penetrable, collectable);
    }
}
