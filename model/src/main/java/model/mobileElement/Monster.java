package model.mobileElement;
import contract.ControllerOrder;
import contract.IModel;
import contract.Permeability;
import contract.StateElement;
import model.Element.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

 
public class Monster extends MobileElement  {
    
	public Monster(String path, IModel model) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING, StateElement.MONSTER);
        this.model = model;
    }
    
	
	// Movement 
	
	public void moveLeft() {

		if (model.getMap().getElement(this.getX() - 1, this.getY()) == null) {
			this.setDirection(ControllerOrder.LEFT);
			this.setX(this.getX() - 1);
		} else {
			moveRight();
		}
		model.flush();
	}

	public void moveRight() {

		if (model.getMap().getElement(this.getX() + 1, this.getY()) == null) {
			this.setDirection(ControllerOrder.RIGHT);
			this.setX(this.getX() + 1);

		} else {
			moveLeft();
		}
		model.flush();

	}

	public void moveUp() {
		if (model.getMap().getElement(this.getX(), this.getY() - 1) == null) {
			this.setDirection(ControllerOrder.UP);
			this.setY(this.getY() - 1);
		}
		else {
			moveDown();
		}
		model.flush();
	}

	public void moveDown() {
			if (model.getMap().getElement(this.getX(), this.getY() + 1) == null) {
				this.setDirection(ControllerOrder.DOWN);
				this.setY(this.getY() + 1);
			}
			else {
				moveUp();
			}
		model.flush();
	}
}
