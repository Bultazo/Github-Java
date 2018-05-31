package contract;

import java.util.ArrayList;

public interface IMap {

     void addElementToMap(IElement element, int x, int y);

     void setElement(int x, int y,IElement element);

     int getID();

     void setID(int ID);

     IElement getElement(int x, int y);

     IElement[][] getElements();

     ArrayList<IMobileElement> getMobiles();

     void setHeroPosition(int x, int y);

     IMobileElement getHero();

     void setHero(IMobileElement hero);

     IMobileElement getSpell();

     void setSpell(IMobileElement spell);

    }
