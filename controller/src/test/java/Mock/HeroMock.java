package Mock;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Permeability;
import contract.StateElement;
import model.IAnimatedSprite;
import model.IHero;
import model.IModel;
import model.ISprite;

public class HeroMock extends MobileElementMock implements IAnimatedSprite {
	AnimatedSpriteMock sprites;
	private IModel model;

	public HeroMock(IModel model2) throws IOException {

		super(Permeability.BLOCKING, StateElement.NOP);
		this.model = model2;
		String Animation[] = { "lorann_b", "lorann_bl", "lorann_l", "lorann_ul", "lorann_u", "lorann_ur", "lorann_r",
				"lorann_br", };

		sprites = new AnimatedSpriteMock((ImageIO.read(new File("sprite/lorann_u.png"))), Animation);
	}

	public void next() {
		sprites.next();
		setImage(sprites.getImage());
	}

	public Image getImage() {
		return null;
	}

	public void setImage(Image image) {

	}

	@Override
	public ISprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}

	public void moveLeft() {
		model.getMap().getHero().setX(model.getMap().getHero().getX() - 1);
		model.flush();
	}

	/*
	 * Overrides the moveRight Method in the implemented interface
	 */
	public void moveRight() {
		model.getMap().getHero().setX(model.getMap().getHero().getX() + 1);
		model.flush();

	}

	/*
	 * Overrides the moveUp Method in the implemented interface
	 */
	public void moveUp() {
		model.getMap().getHero().setY(model.getMap().getHero().getY() - 1);
		model.flush();
	}

	/*
	 * Overrides the moveDown Method in the implemented interface
	 */
	public void moveDown() {
		model.getMap().getHero().setY(model.getMap().getHero().getY() + 1);

		model.flush();
	}

	public void moveDownLeft() {
		model.getMap().getHero().setY(model.getMap().getHero().getY() + 1);
		model.getMap().getHero().setX(model.getMap().getHero().getX() - 1);

		model.flush();
	}

	/*
	 * Overrides the moveRight Method in the implemented interface
	 */
	public void moveDownRight() {
		model.getMap().getHero().setY(model.getMap().getHero().getY() + 1);
		model.getMap().getHero().setX(model.getMap().getHero().getX() + 1);

		model.flush();

	}

	/*
	 * Overrides the moveUp Method in the implemented interface
	 */
	public void moveUpLeft() {
		model.getMap().getHero().setY(model.getMap().getHero().getY() - 1);
		model.getMap().getHero().setX(model.getMap().getHero().getX() - 1);

		model.flush();
	}

	/*
	 * Overrides the moveDown Method in the implemented interface
	 */
	public void moveUpRight() {
		model.getMap().getHero().setY(model.getMap().getHero().getY() - 1);
		model.getMap().getHero().setX(model.getMap().getHero().getX() + 1);

		model.flush();
	}

}
