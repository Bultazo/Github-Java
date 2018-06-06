package Mock;

import contract.Permeability;
import contract.StateElement;
import model.IElement;
import model.ISprite;


public class ElementMock implements IElement {

	    /**
	     * The sprite
	     */
	    private ISprite sprite;
	    /**
	     * The permeability
	     */
	    private Permeability permeability;
	    /**
	     * The stateElement
	     */
	    private StateElement stateElement;

	    
	    /**
	     * The main constructor 
	     */
	    public ElementMock(Permeability permeability,StateElement stateElement) {
	 
	        this.permeability = permeability;
	        this.stateElement = stateElement;
	    }

	    // Getters and setters 
	    
	    /*
	     * Overrides the getSprite Method in the implemented interface
	     */ 
	    public ISprite getSprite() {
	        return this.sprite;
	    }


	    /*
	     * Overrides the setSprite Method in the implemented interface
	     */ 
	    public synchronized void setSprite(ISprite sprite) {
	    this.sprite=sprite;
	    }


	    /*
	     * Overrides the getPermeability Method in the implemented interface
	     */ 
	    public Permeability getPermeability() {
	        return this.permeability;
	    }


	    /*
	     * Overrides the setPermeability Method in the implemented interface
	     */ 
	    public void setPermeability(Permeability permeability) {
	        this.permeability = permeability;
	    }


	    /*
	     * Overrides the getStateElement Method in the implemented interface
	     */ 
	    public StateElement getStateElement() {
	        return this.stateElement;
	    }


	    /*
	     * Overrides the setStateElement Method in the implemented interface
	     */ 
	    public void setStateElement(StateElement stateElement) {
	        this.stateElement = stateElement;
	    }
}
