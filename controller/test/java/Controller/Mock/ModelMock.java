package Controller.Mock;

import contract.*;


import java.io.IOException;
import java.util.Observable;

public class ModelMock extends Observable implements IModel  {


    private String message;

    private MapMock map;


    public ModelMock() {
        loadMap(1);
    }


    public MapMock getMap() {
        return this.map;
    }

    public void loadMap(int ID) {
        this.map=new MapMock(20,12);
        map.setHero(new HeroMock(Permeability.PENETRABLE, StateElement.COLLECTABLE));
        map.setHeroPosition(5,5);
        map.setID(ID);
        map.addElementToMap(new ElementMock(Permeability.PENETRABLE, StateElement.COLLECTABLE),10,10);
        map.getMobiles().add(new MonsterMock());
    }

    public Observable getObservable() {
        return this;
    }

    public void flush() {
        setChanged();
        notifyObservers();
    }

    public int testType(IElement element) {
        if(element instanceof HeroMock)
            return 1;

        if(element instanceof MonsterMock)
            return 2;

        if (element instanceof ElementMock)
            return 3;

        else return 0;
    }

    public void setMessage(String message) {
        this.message=message;
    }

    public String getMessage() {
        return this.message;
    }

    public void createSpell(String path, ControllerOrder direction) throws IOException {

    }

    public void setDoor(IElement door) {
    }

}
