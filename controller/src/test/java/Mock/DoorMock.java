package Mock;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Permeability;
import contract.StateElement;


public class DoorMock extends ElementMock {
	public DoorMock() throws IOException {
		super(Permeability.BLOCKING,
				StateElement.DRAGON);
	}
}
