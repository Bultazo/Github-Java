package model.mobileElement;

import contract.*;
import model.Element.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class Spell extends MobileElement implements IAnimatedSprite {

	private AnimatedSprite sprites;
	private IModel model;

	public Spell(String path, IModel model) throws IOException {
		super((new Sprite(ImageIO.read(new File("sprite/fireball_1.png")))), Permeability.PENETRABLE,
				StateElement.SPELL);
		String Animation[] = { "fireball_1", "fireball_2", "fireball_3", "fireball_4", "fireball_5" };

		sprites = new AnimatedSprite((ImageIO.read(new File("sprite/fireball_1.png"))), Animation);
		this.model = model;
	}

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

	public void next() {
		sprites.next();
		setImage(sprites.getImage());
	}

	public Image getImage() {
		return sprites.getImage();
	}

	public void setImage(Image image) {
		this.getSprite().setImage(image);
	}
}