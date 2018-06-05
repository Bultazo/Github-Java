package Mock;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Permeability;
import contract.StateElement;
import model.IHero;


/**
 * Interface of the Hero.
 * Created by Romain on 20/06/2016.
 * @author Romain
  

  
public class HeroMock extends MobileElementMock implements IHero{
    AnimatedSpriteMock sprites;

	public HeroMock(ModelMock model) throws IOException {

		super(new Sprite(ImageIO.read(new File("sprite/lorann_r.png"))), Permeability.BLOCKING, StateElement.NOP);
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
}
*/