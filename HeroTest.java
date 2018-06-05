/**
 * HeroTest.java
 */
package model.mobileElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Model;

/**
 * @author DELL
 *
 */
/**
 * @author beau gosse sahbi
 *
 */
public class HeroTest {
	/**
	 * The h
	 */
	private Hero h;
	/**
	 * The model
	 */
	private Model model;
	/**
	 * set up 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new Model();
		this.h = new Hero(model);
		this.model.loadMap(1);
		this.model.getMap().setHero(h);
	}

	/**
	 * tear down
	 * @throws java.lang.Exception
	 */
	
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The test to do whenMoveLeft
	 */
	@Test
	public void whenMoveLeft() {
		int posX = model.getMap().getHero().getX() - 1;
		this.h.moveLeft();
		assertEquals(posX, this.model.getMap().getHero().getX());

	}
	
	/**
	 * The test to do whenMoveRight
	 */
	@Test
	public void whenMoveRight() {
		int posX = model.getMap().getHero().getX() + 1;
		this.h.moveRight();
		assertEquals(posX, this.model.getMap().getHero().getX());
		
	}
	
	/**
	 * The test to do whenmoveUp
	 */
	@Test
	public void whenmoveUp() {
		int posY = model.getMap().getHero().getY() - 1;
		this.h.moveUp();
		assertEquals(posY, this.model.getMap().getHero().getY());

	}
	
	/**
	 * The test to do whenmoveDown
	 */
	@Test
	public void whenmoveDown() {
		int posY = model.getMap().getHero().getY() + 1;
		this.h.moveDown();
		assertEquals(posY, this.model.getMap().getHero().getY());

	}
	
	/**
	 * The test to do whenMoveUpLeft
	 */
	@Test
	public void whenMoveUpLeft() {
		int posY = model.getMap().getHero().getY() - 1;
		int posX = model.getMap().getHero().getX() - 1;
		this.h.moveUpLeft();
		assertEquals(posY, this.model.getMap().getHero().getY());
		assertEquals(posX, this.model.getMap().getHero().getX());

	}
	
	/**
	 * The test to do whenMoveUpRight
	 */
	@Test
	public void whenMoveUpRight() {
		int posY = model.getMap().getHero().getY() - 1;
		int posX = model.getMap().getHero().getX() + 1;
		this.h.moveUpRight();
		assertEquals(posY, this.model.getMap().getHero().getY());
		assertEquals(posX, this.model.getMap().getHero().getX());
		
	}
	
	/**
	 * The test to do whenmoveDownLeft
	 */
	@Test
	public void whenmoveDownLeft() {
		int posY = model.getMap().getHero().getY() + 1;
		int posX = model.getMap().getHero().getX() - 1;
		this.h.moveDownLeft();
		assertEquals(posY, this.model.getMap().getHero().getY());
		assertEquals(posX, this.model.getMap().getHero().getX());
	}
	
	/**
	 * The test to do whenmoveDownRight
	 */
	@Test
	public void whenmoveDownRight() {
		int posY = model.getMap().getHero().getY() + 1;
		int posX = model.getMap().getHero().getX() + 1;
		this.h.moveDownRight();
		assertEquals(posY, this.model.getMap().getHero().getY());
		assertEquals(posX, this.model.getMap().getHero().getX());

	}
	
	

}
