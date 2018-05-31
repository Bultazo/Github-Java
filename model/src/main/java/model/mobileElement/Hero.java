package model.mobileElement;

import contract.*;
import model.Element.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Hero extends MobileElement implements IAnimatedSprite {
	private AnimatedSprite sprites;
	private IModel model;

	public Hero(IModel model) throws IOException {

		super(new Sprite(ImageIO.read(new File("sprite/lorann_r.png"))), Permeability.BLOCKING, StateElement.NOP);
		this.model = model;
		String Animation[] = { "lorann_b", "lorann_bl", "lorann_l", "lorann_ul", "lorann_u", "lorann_ur", "lorann_r",
				"lorann_br", };

		sprites = new AnimatedSprite((ImageIO.read(new File("sprite/lorann_b.png"))), Animation);
	}

	public void moveLeft() {
		model.getMap().getHero().setX(model.getMap().getHero().getX() - 1);
		this.setImage(sprites.getImages()[2]);
		model.flush();
	}
	
	public void moveRight() {
		model.getMap().getHero().setX(model.getMap().getHero().getX() + 1);
		this.setImage(sprites.getImages()[6]);
		model.flush();
		
	}
	
	public void moveUp() {
		model.getMap().getHero().setY(model.getMap().getHero().getY() - 1);
		this.setImage(sprites.getImages()[4]);
		model.flush();
	}
	
	public void moveDown() {
		model.getMap().getHero().setY(model.getMap().getHero().getY() + 1);
		this.setImage(sprites.getImages()[0]);
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
