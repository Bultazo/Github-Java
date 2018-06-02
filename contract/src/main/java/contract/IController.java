package contract;
import java.io.IOException;

/**
 * 
 * @author DELL
 *
 */
public interface IController {


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
	 * @return void
	 */
	void orderPerform(ControllerOrder controllerOrder) throws IOException;
	
	/**
	 * Update the game (Ai & spell)
	 * @return void
	 */
	void updateController() ;

	/**
	 * Update lorann sprite 
	 * @return void
	 */
	void updateSprite();
	
	/**
	 * Start the game from the first map
	 * @return void
	 */
	void start();

}
