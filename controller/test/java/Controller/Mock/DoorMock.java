package Controller.Mock;

import contract.IDoor;
import contract.Permeability;
import contract.StateElement;

/**
 * @author Romain
 */
public class DoorMock extends ElementMock implements IDoor{

    public DoorMock(Permeability penetrable, StateElement collectable) {
        super(penetrable, collectable);
    }
}
