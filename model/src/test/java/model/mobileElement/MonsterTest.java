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
 * @author beau gosse sahbi
 *
 */
public class MonsterTest {
	/**
	 * The monster
	 */
	private Monster monster;
	/**
	 * The model
	 */
	private Model model;

	/**
	 * The test to do setUp
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new Model();
		this.monster = new Monster("Monster_1", model);
	}

	
	/**
	 * The test to do tearDown
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The test to do whenMoveLeft
	 */
	@Test
	public void whenMoveLeft() {
		int posX = monster.getX() -1;
		this.monster.moveLeft();
		assertEquals(posX, monster.getX());
		assertEquals(ControllerOrder.LEFT, monster.getDirection());

	}
	
	/**
	 * The test to do whenMoveRight
	 */
	@Test
	public void whenMoveRight() {
		int posX = monster.getX() +1;
		this.monster.moveRight();
		assertEquals(posX, monster.getX());
		assertEquals(ControllerOrder.RIGHT, monster.getDirection());
		
	}
	
	/**
	 * The test to do whenmoveUp
	 */
	@Test
	public void whenmoveUp() {
		int posY = monster.getY() -1;
		this.monster.moveUp();
		assertEquals(posY, monster.getY());
		assertEquals(ControllerOrder.UP, monster.getDirection());

	}
	
	/**
	 * The test to do whenmoveDown
	 */
	@Test
	public void whenmoveDown() {
		int posY = monster.getY() +1;
		this.monster.moveDown();
		assertEquals(posY, monster.getY());
		assertEquals(ControllerOrder.DOWN, monster.getDirection());

	}
}
