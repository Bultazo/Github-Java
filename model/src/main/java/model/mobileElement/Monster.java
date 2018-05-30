package model.mobileElement;

import contract.IMonster;
import contract.Permeability;
import contract.StateElement;
import model.Element.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

 
public class Monster extends MobileElement implements IMonster {

    public Monster(String path) throws IOException {
        super((new Sprite(ImageIO.read(new File("C:/Users/DELL/eclipse-workspace/Lorann-master/Lorann-master/model/sprite/"+path+".png")))), Permeability.BLOCKING, StateElement.DEATH);
    }

}
