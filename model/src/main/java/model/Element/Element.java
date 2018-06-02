package model.Element;import contract.*;public class Element implements IElement {    private ISprite sprite;    private Permeability permeability;    private StateElement stateElement;        public Element(ISprite sprite, Permeability permeability,StateElement stateElement) {        this.sprite = sprite;        this.permeability = permeability;        this.stateElement = stateElement;    }    // Getters and setters         public ISprite getSprite() {        return this.sprite;    }    public synchronized void setSprite(ISprite sprite) {    this.sprite=sprite;    }    public Permeability getPermeability() {        return this.permeability;    }    public void setPermeability(Permeability permeability) {        this.permeability = permeability;    }    public StateElement getStateElement() {        return this.stateElement;    }    public void setStateElement(StateElement stateElement) {        this.stateElement = stateElement;    }}