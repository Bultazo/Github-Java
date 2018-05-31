package model.Element;

import contract.IElement;
import contract.IMap;
import contract.IMobileElement;

import java.util.ArrayList;


public class Map implements IMap{
    
    private int width=20;
    
    private int height=12;
    
    private IElement[][] elements;
    
    private ArrayList<IMobileElement> mobiles;

    private int ID;

    private IMobileElement hero;
   
    private IMobileElement spell;

    public Map(int height, int width) {

        this.height = height;
        this.width = width;
        elements=new Element[this.height][this.width];
        mobiles=new ArrayList<IMobileElement>();
    }

    
    public IElement getElement(int x, int y) {
        return elements[x][y];
    }

    
    public void setElement(int x, int y,IElement element){
        this.elements[x][y]=element;
    }

    
    public IElement[][] getElements() {
        return elements;
    }

    
    public ArrayList<IMobileElement> getMobiles() {
        return mobiles;
    }



    
    public void addElementToMap(IElement element, int x, int y)
    {
        this.elements[x][y]=element;
    }


    public int getID() {
        return ID;
    }

    
    public void setID(int ID) {
        this.ID = ID;
    }

    
    public void setHeroPosition(int x, int y){
        this.hero.setX(x);
        this.hero.setY(y);
    }

    
    public IMobileElement getHero(){
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
