package Mock;

import contract.Permeability;
import contract.StateElement;

/**
 * @author Samir
 *
 */
public class MonsterMock extends MobileElementMock {
    /**
     * The main constructor 
     */
    public MonsterMock() {
        super(Permeability.BLOCKING, StateElement.MONSTER);
    }
}
