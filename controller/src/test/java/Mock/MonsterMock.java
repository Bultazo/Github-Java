package Mock;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Permeability;
import contract.StateElement;


/**
 * @author Samir
 *
 */
public class MonsterMock extends MobileElementMock {
    /**
     * The main constructor 
     */
	private ModelMock model;
	
	public MonsterMock(String path, ModelMock model) throws IOException {
		super((new SpriteMock(ImageIO.read(new File("sprite/" + path + ".png")))), Permeability.BLOCKING,
				StateElement.NOP);
		this.model = model;
	}
}
