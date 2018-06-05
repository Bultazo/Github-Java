package Mock;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.Permeability;
import contract.StateElement;


public class DoorMock extends ElementMock {
	public DoorMock() throws IOException {
		super((new SpriteMock(ImageIO.read(new File("sprite/gate_closed.png")))), Permeability.BLOCKING,
				StateElement.DRAGON);
	}
}
