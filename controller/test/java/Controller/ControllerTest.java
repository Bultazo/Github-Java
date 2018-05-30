package Controller;

import Controller.Mock.ControllerMock;
import Controller.Mock.DoorMock;
import Controller.Mock.ModelMock;
import Controller.Mock.ViewMock;
import contract.IMobileElement;
import contract.Permeability;
import contract.StateElement;
import controller.Controller;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Romain
 */
public class ControllerTest {

    /**
     * The controller.
     */
    private ControllerMock t;

    /**
     * Sets the UP.
     * @throws Exception
     *      The exception.
     */
    @Before
    public void setUp() throws Exception {
        this.t = new ControllerMock(new ViewMock(), new ModelMock());
    }

    /**
     * Tests the hero's movements.
     * @throws Exception
     *      The exception.
     */
    @Test
    public void moveHeroTest() throws Exception {
        assertNotNull("Hero should not be null",t.getModelMock().getMap().getHero());

        int heroPositionBefore=t.getModelMock().getMap().getHero().getX();  //Stock position of the hero before move.
        t.moveHero(1,0);
        assertNotEquals("X position should be different",heroPositionBefore,t.getModelMock().getMap().getHero().getX());
        assertEquals("X should be the same",heroPositionBefore+1,t.getModelMock().getMap().getHero().getX());
    }

    /**
     * Tests the contact between the monster and any other element.
     * @throws Exception
     *      The exception.
     */
    @Test
    public void contactMonsterTest() throws Exception {
        assertNotNull("Monster should not be null",t.getModelMock().getMap().getMobiles());
        for(IMobileElement monster: t.getModelMock().getMap().getMobiles())
        {
            monster.setX(10);
            monster.setY(10);
        }
        t.getModelMock().getMap().addElementToMap(new DoorMock(Permeability.BLOCKING, StateElement.COLLECTABLE),10,10);
        assertFalse("It should not be able to go",t.contactMonster(10,10));

    }

    /**
     * Tests the contact between the hero and any other element.
     * @throws Exception
     *      The exception.
     */
    @Test
    public void contactHeroTest() throws Exception {
        assertNotNull("Hero should not be null",t.getModelMock().getMap().getHero());
        t.getModelMock().getMap().getHero().setY(10);
        t.getModelMock().getMap().getHero().setX(10);
        t.getModelMock().getMap().addElementToMap(new DoorMock(Permeability.PENETRABLE, StateElement.DRAGON), 10, 10);
        assertFalse("The door is closed",t.contactHero(10,10));
        t.getModelMock().getMap().getElement(10,10).setStateElement(StateElement.DOOR);
        assertTrue("The door should be open",t.contactHero(10,10));

        assertTrue("It should not have an element here",t.contactHero(10,11));

    }

    @Test
    public void AIMonsterTest() throws Exception {

    }

    @Test
    public void orderPerformTest() throws Exception {

    }

    @Test
    public void gameOverTest() throws Exception {

    }

    @Test
    public void castSpellTest() throws Exception {

    }

    @Test
    public void isSpellTest() throws Exception {

    }

    @Test
    public void updateControllerTest() throws Exception {

    }

    @Test
    public void updateSpriteTest() throws Exception {

    }

    @Test
    public void moveSpellTest() throws Exception {

    }

    @Test
    public void moveSpellDirectionTest() throws Exception {

    }

    @Test
    public void destroySpellTest() throws Exception {

    }

    @Test
    public void destroyMonsterTest() throws Exception {

    }

    @Test
    public void canCastSpellTest() throws Exception {

    }

}