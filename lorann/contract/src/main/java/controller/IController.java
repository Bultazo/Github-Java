package controller;
import java.io.IOException;

import contract.ControllerOrder;
import model.IMobileElement;

/**
 * 
 * @author DELL
 *
 */
public interface IController {

	/**
	 * 
	 * The (REALLY BASIC) Monster AI
	 * 
	 */
	void AIMonster();

	/**
	 * Test contact between monsters and elements
	 * @param x
	 * 			easting
	 * @param y
	 * 			northing
     * @return boolean
     */
	boolean contactMonster(int x, int y, IMobileElement monster);

	/**
	 * Test contact between the hero and the elements
	 * @param x
	 * 			easting
	 * @param y
	 * 			northing
     * @return boolean
     */
	boolean contactHero(int x,int y);


	/**
	 * Gets the order from the view
	 * 
	 */
	void orderPerform(ControllerOrder controllerOrder) throws IOException;
	
	/**
	 * Update the game (Ai & spell)
	 * 
	 */
	void updateController() ;

	/**
	 * Update lorann sprite 
	 * 
	 */
	void updateSprite();
	
	/**
	 * Start the game from the first map
	 * 
	 */
	void start();

}
