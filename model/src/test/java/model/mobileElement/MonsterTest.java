/**
 * MonsterTest.java
 */
package model.mobileElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.ControllerOrder;
import model.Model;

/**
 * @author DELL
 *
 */
public class MonsterTest {
	private Monster monster;
	private Model model;
	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new Model();
		this.monster = new Monster("Monster_1", model);
	}

	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void whenMoveLeft() {
		int posX = monster.getX() -1;
		this.monster.moveLeft();
		assertEquals(posX, monster.getX());
		assertEquals(ControllerOrder.LEFT, monster.getDirection());

	}
	
	@Test
	public void whenMoveRight() {
		int posX = monster.getX() +1;
		this.monster.moveRight();
		assertEquals(posX, monster.getX());
		assertEquals(ControllerOrder.RIGHT, monster.getDirection());
		
	}
	
	@Test
	public void whenmoveUp() {
		int posY = monster.getY() -1;
		this.monster.moveUp();
		assertEquals(posY, monster.getY());
		assertEquals(ControllerOrder.UP, monster.getDirection());

	}
	
	@Test
	public void whenmoveDown() {
		int posY = monster.getY() +1;
		this.monster.moveDown();
		assertEquals(posY, monster.getY());
		assertEquals(ControllerOrder.DOWN, monster.getDirection());

	}
}
