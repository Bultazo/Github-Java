/**
 * SpellTest.java
 */
package model.mobileElement;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Model;
import model.motionLessElement.BoneC;

/**
 * @author DELL
 *
 */
public class SpellTest {
	
	private Model model;
	private Spell spell;
	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new Model();
		this.spell = new Spell("fireball", model);
		spell.setX(5);
		spell.setY(5);
		this.model.loadMap(8);
		this.model.getMap().setSpell(spell);
	}

	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void whenMoveUpWithObstacle() throws IOException {
		int pos = spell.getY() +1;
		this.model.getMap().setElement(spell.getX(), spell.getY() -1, new BoneC());
		this.spell.moveUp();
		assertEquals(pos, spell.getY());
	}
	
	@Test
	public void whenMoveUpWithNoObstacle() {
		
	}


}
