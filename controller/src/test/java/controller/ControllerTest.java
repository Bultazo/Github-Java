/**
 * ControllerTest.java
 */
package controller;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Mock.ControllerMock;
import Mock.DoorMock;
import Mock.ModelMock;
import Mock.MonsterMock;
import Mock.SpellMock;
import Mock.ViewMock;
import contract.ControllerOrder;
import contract.Sounds;
import contract.StateElement;
import model.IMobileElement;
import model.IModel;
import view.IView;

/**
 * @author DELL
 *
 */
/**
 * @author DELL
 *
 */
public class ControllerTest {
	/**
	 * The model
	 */
	private IModel model;
	/**
	 * The view
	 */
	private IView view;
	/**
	 * The controller
	 */
	private ControllerMock controller;
	

	/**
	 * The test setUp
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new ModelMock();
		this.view = new ViewMock();
		this.controller = new ControllerMock(view, model);
		this.controller.start();
		
	}

	
	/**
	 * The test tearDown
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The test whenGameOverNolives
	 */
	@Test
	public void whenGameOverNolives() {
		this.controller.model.setResurrections(0);
		this.controller.gameOver();
		assertEquals(-1, this.controller.model.getResurrections());
		assertEquals("NO LIVES LEFT !! \nPress R to retry", this.controller.model.getMessage());
	}
	
	/**
	 * The test whenGameOverlives
	 */
	@Test
	public void whenGameOverlives() {
		this.controller.model.setResurrections(10);
		this.controller.gameOver();
		assertEquals(9, this.controller.model.getResurrections());
		assertEquals("GAME OVER !\n Press R to restart", this.controller.model.getMessage());
	}

	
	/**
	 * The test whenorderPerformLeft
	 * @throws IOException
	 */
	@Test
	public void whenorderPerformLeft() throws IOException {
		int posX = controller.model.getMap().getHero().getX() - 1;
		this.controller.orderPerform(ControllerOrder.LEFT);
		assertEquals(posX, this.controller.lorann.getX());

	}
	
	/**
	 * The test whenorderPerformRight
	 * @throws IOException
	 */
	@Test
	public void whenorderPerformRight() throws IOException {
		int posX = controller.model.getMap().getHero().getX() + 1;
		this.controller.orderPerform(ControllerOrder.RIGHT);
		assertEquals(posX, this.controller.lorann.getX());
		
	}
	
	/**
	 * The test whenorderPerformUp
	 * @throws IOException
	 */
	@Test
	public void whenorderPerformUp() throws IOException {
		int posY = controller.model.getMap().getHero().getY() - 1;
		this.controller.orderPerform(ControllerOrder.UP);
		assertEquals(posY, this.controller.lorann.getY());

	}
	
	/**
	 * The test whenorderPerformDown
	 * @throws IOException
	 */
	@Test
	public void whenorderPerformDown() throws IOException {
		int posY = controller.model.getMap().getHero().getY() + 1;
		this.controller.orderPerform(ControllerOrder.DOWN);
		assertEquals(posY, this.controller.lorann.getY());

	}
	
	/**
	 * The test whenorderPerformUpLeft
	 * @throws IOException
	 */
	@Test
	public void whenorderPerformUpLeft() throws IOException {
		int posY = controller.model.getMap().getHero().getY() - 1;
		int posX = controller.model.getMap().getHero().getX() - 1;
		this.controller.orderPerform(ControllerOrder.UPLEFT);
		assertEquals(posY, this.controller.lorann.getY());
		assertEquals(posX, this.controller.lorann.getX());

	}
	
	/**
	 * The test whenorderPerformUpRight
	 * @throws IOException
	 */
	@Test
	public void whenorderPerformUpRight() throws IOException {
		int posY = controller.model.getMap().getHero().getY() - 1;
		int posX = controller.model.getMap().getHero().getX() + 1;
		this.controller.orderPerform(ControllerOrder.UPRIGHT);
		assertEquals(posY, this.controller.lorann.getY());
		assertEquals(posX, this.controller.lorann.getX());
		
	}
	
	/**
	 * The test whenorderPerformDownLeft
	 * @throws IOException
	 */
	@Test
	public void whenorderPerformDownLeft() throws IOException {
		int posY = controller.model.getMap().getHero().getY() + 1;
		int posX = controller.model.getMap().getHero().getX() - 1;
		this.controller.orderPerform(ControllerOrder.DOWNLEFT);
		assertEquals(posY, this.controller.lorann.getY());
		assertEquals(posX, this.controller.lorann.getX());
	}
	
	/**
	 * The test whenorderPerformDownRight
	 * @throws IOException
	 */
	@Test
	public void whenorderPerformDownRight() throws IOException {
		int posY = controller.model.getMap().getHero().getY() + 1;
		int posX = controller.model.getMap().getHero().getX() + 1;
		this.controller.orderPerform(ControllerOrder.DOWNRIGHT);
		assertEquals(posY, this.controller.lorann.getY());
		assertEquals(posX, this.controller.lorann.getX());

	}
	/**
	 * The test whenorderPerformDownSpace
	 * @throws IOException
	 */
	@Test
	public void whenorderPerformDownSpace() throws IOException {
		

	}
	/**
	 * The test whenorderPerformRetryNoLives
	 * @throws IOException
	 */
	@Test
	public void whenorderPerformRetryNoLives() throws IOException {
		this.controller.model.setResurrections(0);
		this.controller.model.getMap().setID(2);
		this.controller.model.getMap().setSpell(new SpellMock("fireball", this.controller.model));
		this.controller.orderPerform(ControllerOrder.RETRY);
		assertEquals(null, this.controller.model.getMap().getSpell());
		assertEquals(1, this.controller.model.getMap().getID());

	}
	/**
	 * The test whenorderPerformRetryLives
	 * @throws IOException
	 */
	@Test
	public void whenorderPerformRetryLives() throws IOException {
		this.controller.model.setResurrections(10);
		
		this.controller.model.getMap().setID(2);
		this.controller.model.setMessage("Test TEST");
		this.controller.DeadMonsters.add(new MonsterMock("monster_1", model));
		
		this.controller.orderPerform(ControllerOrder.RETRY);

		assertEquals(2, this.controller.model.getMap().getID());
		assertEquals(true, this.controller.DeadMonsters.isEmpty());
		assertEquals("", this.controller.model.getMessage());
	}
	
	/**
	 * The test contactHeroFalse
	 * @throws IOException
	 */
	@Test
	public void contactHeroFalse() throws IOException {
		MonsterMock monster = new MonsterMock("monster_1", model);
		this.controller.model.getMap().getMobiles().add(monster);
		monster.setX(this.controller.lorann.getX()-1);
		monster.setY(this.controller.lorann.getY());
		assertEquals(false, this.controller.contactHero(this.controller.lorann.getX()-1, this.controller.lorann.getY()));
		assertEquals(null, this.controller.lorann);
	
	}
	/**
	 * The test contactHeroTrue
	 * @throws IOException
	 */
	@Test
	public void contactHeroTrue() throws IOException {
		
		assertEquals(true, this.controller.contactHero(this.controller.lorann.getX()-1, this.controller.lorann.getY()));
	
	}
	
}
