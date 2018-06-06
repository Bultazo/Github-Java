package Mock;



import java.util.ArrayList;

import model.IElement;
import model.IMap;
import model.IMobileElement;



public class MapMock implements IMap{

    /**
     * The width
     */
    private int width=20;
    
    /**
     * The height
     */
    private int height=12;
    
    /**
     * The Door
     */
    private IElement Door;
    
    /**
     * The elements
     */
    private IElement[][] elements;
    
    /**
     * The list of monsters
     */
    private ArrayList<IMobileElement> mobiles;

    /**
     * The ID
     */
    private int ID;

    /**
     * The hero
     */
    private IMobileElement hero;
   
    /**
     * The spell
     */
    private IMobileElement spell;

    /**
     * The main constructor 
     */
    public MapMock(int height, int width, IMobileElement hero) {
    	this.hero = hero;
        this.height = height;
        this.width = width;
        elements=new ElementMock[this.height][this.width];
        mobiles=new ArrayList<IMobileElement>();
    }

    /*
     * Overrides the addElementToMap Method in the implemented interface
     */ 
    public void addElementToMap(IElement element, int x, int y)
    {
        this.elements[x][y]=element;
    }


	// Getters and setters
    
    /*
     * Overrides the getID Method in the implemented interface
     */ 
    public int getID() {
        return ID;
    }

    
    /*
     * Overrides the setID Method in the implemented interface
     */ 
    public void setID(int ID) {
        this.ID = ID;
    }
    
    /*
     * Overrides the getElement Method in the implemented interface
     */ 
    public IElement getElement(int x, int y) {
        return elements[x][y];
    }

    
    /*
     * Overrides the setElement Method in the implemented interface
     */ 
    public void setElement(int x, int y,IElement element){
        this.elements[x][y]=element;
    }

    
    /*
     * Overrides the getElements Method in the implemented interface
     */ 
    public IElement[][] getElements() {
        return elements;
    }

    
    /*
     * Overrides the getMobiles Method in the implemented interface
     */ 
    public ArrayList<IMobileElement> getMobiles() {
        return mobiles;
    }
    
    /*
     * Overrides the setHeroPosition Method in the implemented interface
     */ 
    public void setHeroPosition(int x, int y){
        this.hero.setX(x);
        this.hero.setY(y);
    }

    
    /*
     * Overrides the getHero Method in the implemented interface
     */ 
    public IMobileElement getHero(){
        return this.hero;
    }

    
    /*
     * Overrides the setHero Method in the implemented interface
     */ 
    public void setHero(IMobileElement hero) {
        this.hero = hero;
    }


    
    /*
     * Overrides the getSpell Method in the implemented interface
     */ 
    public IMobileElement getSpell() {
        return spell;
    }

    
    /*
     * Overrides the setSpell Method in the implemented interface
     */ 
    public void setSpell(IMobileElement spell) {
        this.spell = spell;
    }


	/*
	 * Overrides the getDoor Method in the implemented interface
	 */ 
	public IElement getDoor() {
		return Door;
	}


	/*
	 * Overrides the setDoor Method in the implemented interface
	 */ 
	public void setDoor(IElement door) {
		Door = door;
	}



}
