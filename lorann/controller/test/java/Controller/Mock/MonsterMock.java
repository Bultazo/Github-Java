package Controller.Mock;

import Controller.Mock.MobileElementMock;
import contract.IMonster;
import contract.Permeability;
import contract.StateElement;

public class MonsterMock extends MobileElementMock implements IMonster {
    public MonsterMock() {
        super(Permeability.BLOCKING, StateElement.WEAK);
    }
}
