package model.mobileElement;

import contract.*;
import model.Element.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class Spell extends MobileElement implements IAnimatedSprite {

	private AnimatedSprite sprites;

	public Spell(String path, ControllerOrder direction) throws IOException {
		super((new Sprite(ImageIO.read(new File("sprite/fireball_1.png")))), Permeability.PENETRABLE,
				StateElement.SPELL);
		String Animation[] = { "fireball_1", "fireball_2", "fireball_3", "fireball_4", "fireball_5"};

		sprites = new AnimatedSprite((ImageIO.read(new File("sprite/fireball_1.png"))), Animation);
		this.setDirection(direction);
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