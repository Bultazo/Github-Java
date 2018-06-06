package Mock;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Permeability;
import contract.StateElement;
import model.IModel;


/**
 * @author Samir
 *
 */
public class MonsterMock extends MobileElementMock {
    /**
     * The main constructor 
     */
	private IModel model;
	
	public MonsterMock(String path, IModel model2) throws IOException {
		super(Permeability.BLOCKING,
				StateElement.NOP);
		this.model = model2;
	}
}
