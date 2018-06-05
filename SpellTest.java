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
		this.model.loadBlankMap();
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
		int pos = spell.getY() + 1;
		this.model.getMap().setElement(spell.getX(), spell.getY() - 1, new BoneC());
		this.spell.moveUp();
		assertEquals(pos, spell.getY());
	}

	@Test
	public void whenMoveUpWithNoObstacle() {
		int pos = spell.getY() - 1;
		this.spell.moveUp();
		assertEquals(pos, spell.getY());
	}
	
	@Test
	public void whenMoveDownWithNoObstacle() {
		int pos = spell.getY() + 1;
		this.spell.moveDown();
		assertEquals(pos, spell.getY());
		}
	
	@Test
	public void whenMoveDownWithObstacle() throws IOException {
		int pos = spell.getY() - 1;
		this.model.getMap().setElement(spell.getX(), spell.getY() + 1, new BoneC());
		this.spell.moveDown();
		assertEquals(pos, spell.getY());
	}
	
	@Test
	public void whenMoveRightWithNoObstacle() throws IOException {
		int pos = spell.getX() + 1;
		this.spell.moveRight();
		assertEquals(pos, spell.getX());
	}
	
	@Test
	public void whenMoveRightWithObstacle() throws IOException {
		int pos = spell.getX() - 1;
		this.model.getMap().setElement(spell.getX() + 1, spell.getY(), new BoneC());
		this.spell.moveRight();
		assertEquals(pos, spell.getX());
	}
	
	@Test
	public void whenMoveLefttWithObstacle() throws IOException {
		int pos = spell.getX() + 1;
		this.model.getMap().setElement(spell.getX() - 1, spell.getY(), new BoneC());
		this.spell.moveLeft();
		assertEquals(pos, spell.getX());
	}
	
	@Test
	public void whenMoveLeftWithNoObstacle() throws IOException {
		int pos = spell.getX() - 1;
		this.spell.moveLeft();
		assertEquals(pos, spell.getX());
	}
	
	
	
	
}
