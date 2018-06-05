/**
 * ModelTest.java
 */
package model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contract.ControllerOrder;

/**
 * @author DELL
 *
 */
public class ModelTest {
	private Model model;

	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new Model();
		this.model.loadMap(1);
	}

	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void whenGettingElementsByANormalID() throws SQLException {
		int idExp = 1;
		ResultSet rset = this.model.getElementById(idExp);
		if (rset.first()) {
			assertEquals(idExp, rset.getInt("niveau"));
		}
	}

	@Test
	public void whenGettingElementsByAStrangeID() throws SQLException {
		int idExp = -1;
		ResultSet rset = this.model.getElementById(idExp);
		assertEquals(false, rset.first());
	}
	
	
	@Test
	public void whenCreatingSpellHeroUp() throws SQLException, IOException {
		this.model.getMap().getHero().setDirection(ControllerOrder.UP);
		this.model.createSpell("fireball");
		assertEquals(ControllerOrder.DOWN, this.model.getMap().getSpell().getDirection());
		assertEquals(this.model.getMap().getHero().getY() +1, this.model.getMap().getSpell().getY());
	}

	@Test
	public void whenCreatingSpellHeroDown() throws SQLException, IOException {
		this.model.getMap().getHero().setDirection(ControllerOrder.DOWN);
		this.model.createSpell("fireball");
		assertEquals(ControllerOrder.UP, this.model.getMap().getSpell().getDirection());
		assertEquals(this.model.getMap().getHero().getY() -1, this.model.getMap().getSpell().getY());
	}
	
	@Test
	public void whenCreatingSpellHeroLeft() throws SQLException, IOException {
		this.model.getMap().getHero().setDirection(ControllerOrder.LEFT);
		this.model.createSpell("fireball");
		assertEquals(ControllerOrder.RIGHT, this.model.getMap().getSpell().getDirection());
		assertEquals(this.model.getMap().getHero().getX() +1, this.model.getMap().getSpell().getX());
	}
	
	@Test
	public void whenCreatingSpellHeroRight() throws SQLException, IOException {
		this.model.getMap().getHero().setDirection(ControllerOrder.RIGHT);
		this.model.createSpell("fireball");
		assertEquals(ControllerOrder.LEFT, this.model.getMap().getSpell().getDirection());
		assertEquals(this.model.getMap().getHero().getX() -1, this.model.getMap().getSpell().getX());
	}
}
