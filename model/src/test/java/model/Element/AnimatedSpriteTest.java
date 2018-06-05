/**
 * AnimatedSpriteTest.java
 */
package model.Element;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Model;
import model.mobileElement.Hero;

/**
 * @author DELL
 *
 */
public class AnimatedSpriteTest {
	
	private AnimatedSprite anim;
	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void whenImageisNext() throws IOException {
		String Animation[] = { "lorann_b", "lorann_bl", "lorann_l", "lorann_ul", "lorann_u", "lorann_ur", "lorann_r",
				"lorann_br", };
		anim = new AnimatedSprite((ImageIO.read(new File("sprite/lorann_u.png"))), Animation);
		anim.next();
		assertEquals(anim.getImages()[1], anim.getImage());
	}

}
