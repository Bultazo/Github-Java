package Controller.Mock;

import contract.IHero;
import contract.Permeability;
import contract.StateElement;

import java.awt.*;

/**
 * Interface of the Hero.
 * Created by Romain on 20/06/2016.
 * @author Romain
 */
public class HeroMock extends MobileElementMock implements IHero{
    AnimatedSpriteMock sprites;

    public HeroMock(Permeability penetrable, StateElement collectable) {
        super(penetrable, collectable);
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
