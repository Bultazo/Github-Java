package model;

import java.util.ArrayList;

public interface IMap {

     /**
     * Adds un element to the map
     * @return void
     */
    void addElementToMap(IElement element, int x, int y);

     /**
     * Sets the Element
     * @return void
     */
    void setElement(int x, int y,IElement element);

     /**
     * Gets the ID of the level
     * @return int
     */
    int getID();

     /**
     * Sets the ID of the level
     * @return void
     */
    void setID(int ID);

     /**
     * Gets the element
     * @return IElement
     */
    IElement getElement(int x, int y);

     /**
     * Gets the list of all the elements : The map.
     * @return IElement[][]
     */
    IElement[][] getElements();

     /**
     * Gets the monsters 
     * @return ArrayList<IMobileElement>
     */
    ArrayList<IMobileElement> getMobiles();

     /**
     * Sets the initial position of the hero 
     * @return void
     */
    void setHeroPosition(int x, int y);

     /**
     * Gets the Hero
     * @return IMobileElement
     */
    IMobileElement getHero();

     /**
     * Sets the Hero in the level
     * @return void
     */
    void setHero(IMobileElement hero);

     /**
     * Gets the Spell
     * @return IMobileElement
     */
    IMobileElement getSpell();

     /**
     * Sets the Spell
     * @return void
     */
    void setSpell(IMobileElement spell);
     
     /**
     * Gets the door
     * @return IElement
     */
    IElement getDoor();
     
     /**
     * Sets the door
     * @return void
     */
    void setDoor(IElement Door);

    }
