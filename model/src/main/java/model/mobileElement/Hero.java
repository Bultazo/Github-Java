package model.mobileElement;

import contract.*;
import model.Element.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author DELL
 *
 */
public class Hero extends MobileElement implements IAnimatedSprite {
	/**
	 * The sprites
	 */
	private AnimatedSprite sprites;

	/**
	 * The main constructor 
	 * @throws IOException
     * 		Can't read file
	 */
	public Hero(IModel model) throws IOException {

		super(new Sprite(ImageIO.read(new File("sprite/lorann_r.png"))), Permeability.BLOCKING, StateElement.NOP);
		this.model = model;
		String Animation[] = { "lorann_b", "lorann_bl", "lorann_l", "lorann_ul", "lorann_u", "lorann_ur", "lorann_r",
				"lorann_br", };

		sprites = new AnimatedSprite((ImageIO.read(new File("sprite/lorann_u.png"))), Animation);
	}
	
	// Movement
	
	/*
	 * Overrides the moveLeft Method in the implemented interface
	 */ 
	public void moveLeft() {
		model.getMap().getHero().setX(model.getMap().getHero().getX() - 1);
		this.setImage(sprites.getImages()[2]);
		model.flush();
	}
	
	/*
	 * Overrides the moveRight Method in the implemented interface
	 */ 
	public void moveRight() {
		model.getMap().getHero().setX(model.getMap().getHero().getX() + 1);
		this.setImage(sprites.getImages()[6]);
		model.flush();
		
	}
	
	/*
	 * Overrides the moveUp Method in the implemented interface
	 */ 
	public void moveUp() {
		model.getMap().getHero().setY(model.getMap().getHero().getY() - 1);
		this.setImage(sprites.getImages()[4]);
		model.flush();
	}
	
	/*
	 * Overrides the moveDown Method in the implemented interface
	 */ 
	public void moveDown() {
		model.getMap().getHero().setY(model.getMap().getHero().getY() + 1);
		this.setImage(sprites.getImages()[0]);
		model.flush();
	}
	/*
	 * Overrides the next Method in the implemented interface
	 */ 
	public void next() {
		sprites.next();
		setImage(sprites.getImage());
	}
	
	// Getters and setters
	
	/*
	 * Overrides the getImage Method in the implemented interface
	 */ 
	public Image getImage() {
		return sprites.getImage();
	}

	/*
	 * Overrides the setImage Method in the implemented interface
	 */ 
	public void setImage(Image image) {
		this.getSprite().setImage(image);
	}
}
