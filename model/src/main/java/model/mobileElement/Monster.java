package model.mobileElement;

import contract.ControllerOrder;
import contract.Permeability;
import contract.StateElement;
import model.IModel;
import model.Element.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * @author DELL
 *
 */
public class Monster extends MobileElement {


	/**
	 * The main constructor
	 * 
	 * @throws IOException
	 *             Can't read file
	 */
	public Monster(String path, IModel model) throws IOException {
		super((new Sprite(ImageIO.read(new File("sprite/" + path + ".png")))), Permeability.BLOCKING,
				StateElement.NOP);
		this.model = model;
	}

	// Movement

	/*
	 * Overrides the moveLeft Method in the implemented interface
	 */
	public void moveLeft() {
		this.setDirection(ControllerOrder.LEFT);
		this.setX(this.getX() - 1);

	}

	/*
	 * Overrides the moveRight Method in the implemented interface
	 */
	public void moveRight() {
		this.setDirection(ControllerOrder.RIGHT);
		this.setX(this.getX() +1);

	}

	/*
	 * Overrides the moveUp Method in the implemented interface
	 */
	public void moveUp() {

		this.setDirection(ControllerOrder.UP);
		this.setY(this.getY() - 1);

	}

	/*
	 * Overrides the moveDown Method in the implemented interface
	 */
	public void moveDown() {

		this.setDirection(ControllerOrder.DOWN);
		this.setY(this.getY() + 1);

	}
}
