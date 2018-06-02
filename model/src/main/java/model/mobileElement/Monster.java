package model.mobileElement;
import contract.Permeability;
import contract.StateElement;
import model.Element.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

 
public class Monster extends MobileElement  {

    public Monster(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("sprite/"+path+".png")))), Permeability.BLOCKING, StateElement.MONSTER);
    }

}
