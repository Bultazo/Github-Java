package model.mobileElement;
import model.Element.*;
import contract.*;

public class MobileElement extends Element implements IMobileElement{
	
    private int x;

    private int y;

    private ISprite sprite;
         
    private Permeability permeability;

    private StateElement stateElement;
  
    private ControllerOrder direction;
    
    protected IModel model;

    public MobileElement(Sprite sprite, Permeability permeability, StateElement stateElement) {
        super(sprite,permeability,stateElement);
    }


    public int getY() {
        return y;
    }


    public void setY(int y) {this.y = y;}


    public int getX() {return x;}


    public void setX(int x) {this.x = x;}

  
    public synchronized void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }


    public Permeability getPermeability() {
        return permeability;
    }

 
    public void setDirection(ControllerOrder direction){
        this.direction = direction;
    }

     
    public ControllerOrder getDirection() {
        return direction;
    }

     
    public void setPermeability(Permeability permeability) {
        this.permeability = permeability;
    }

     
    public StateElement getStateElement() {
        return stateElement;
    }

     
    public void setStateElement(StateElement stateElement) {
        this.stateElement = stateElement;
    }


	/* (non-Javadoc)
	 * @see contract.IMobileElement#moveLeft()
	 */
	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see contract.IMobileElement#moveRight()
	 */
	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see contract.IMobileElement#moveUp()
	 */
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see contract.IMobileElement#moveDown()
	 */
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

}
