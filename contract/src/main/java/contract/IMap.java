package contract;

import java.util.ArrayList;

/**
 * Interface of the map.
 * @author Romain
 */
public interface IMap {

     void addElementToMap(IElement element, int x, int y);

     void setElement(int x, int y,IElement element);

     void setScore(int score);

     int getScore();

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
