package model;

import java.util.ArrayList;

public interface IMap {

     /**
     * Adds an element to the map
     * @param element, y, x
     *         the element to map.
     * 
     */
    void addElementToMap(IElement element, int x, int y);

     /**
     * Sets the Element
     * @param element, x, y
     *        the element to set.
     *        
     */
    void setElement(int x, int y,IElement element);

     /**
     * Gets the ID of the level
     * @return int
     */
    int getID();

     /**
     * Sets the ID of the level
     * @param ID
     *       the ID to set.
     * 
     */
    void setID(int ID);

     /**
     * Gets the element
     * @return IElement
     * @param x, y
     *        the element.
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
     * @param x, y
     *        the hero position to set.
     * 
     */
    void setHeroPosition(int x, int y);

     /**
     * Gets the Hero
     * @return IMobileElement
     */
    IMobileElement getHero();

     /**
     * Sets the Hero in the level
     * @param hero
     *        the hero to set.
     * 
     */
    void setHero(IMobileElement hero);

     /**
     * Gets the Spell
     * @return IMobileElement
     */
    IMobileElement getSpell();

     /**
     * Sets the Spell
     * @param spell 
     *        the spell to set. 
     *        
     */
    void setSpell(IMobileElement spell);
     
     /**
     * Gets the door
     * @return IElement
     */
    IElement getDoor();
     
     /**
     * Sets the door
     * @param Door
     *        the door to set. 
     *        
     */
    void setDoor(IElement Door);

    }
