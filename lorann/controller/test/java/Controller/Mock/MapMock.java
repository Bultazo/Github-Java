package Controller.Mock;

import contract.IElement;
import contract.IMap;
import contract.IMobileElement;

import java.util.ArrayList;

/**
 * Created by Romain on 20/06/2016.
 */
public class MapMock implements IMap{
    IElement[][] elements;
    IMobileElement spell;
    IMobileElement hero;
    int score;
    int ID;
    ArrayList<IMobileElement> mobiles;

    public MapMock(int i, int i1) {
        this.elements=new IElement[i][i1];
        this.mobiles=new ArrayList<IMobileElement>();
    }

    public void addElementToMap(IElement element, int x, int y) {
        this.elements[x][y]=element;
    }

    public void setElement(int x, int y, IElement element) {
        this.elements[x][y]=element;
    }

    public void setScore(int score) {
        this.score=score;
    }

    public int getScore() {
        return this.score;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public IElement getElement(int x, int y) {
        return elements[x][y];
    }

    public IElement[][] getElements() {
        return elements;
    }

    public ArrayList<IMobileElement> getMobiles() {
        return mobiles;
    }

    public void setHeroPosition(int x, int y) {
        this.hero.setX(x);
        this.hero.setY(y);
    }

    public IMobileElement getHero() {
        return this.hero;
    }

    public void setHero(IMobileElement hero) {
        this.hero = hero;
    }

    public IMobileElement getSpell() {
        return spell;
    }

    public void setSpell(IMobileElement spell) {
        this.spell = spell;
    }
}
