package Mock;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Permeability;
import contract.StateElement;
import model.IHero;
import model.ISprite;

public class HeroMock extends MobileElementMock implements IHero {
	AnimatedSpriteMock sprites;
	private ModelMock model;
	public HeroMock(ModelMock model) throws IOException {

		super(new SpriteMock(ImageIO.read(new File("sprite/lorann_r.png"))), Permeability.BLOCKING, StateElement.NOP);
		this.model = model;
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

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDownLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDownRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUpLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUpRight() {
		// TODO Auto-generated method stub
		
	}

}
