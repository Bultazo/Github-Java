package contract;

import java.io.IOException;

/**
 * The Interface IController.
 *
 * @author Tanguy Blochet
 */
public interface IController {


	/**
	 * Move the hero
	 * @param x
	 * 			easting
	 * @param y
	 * 			northing
     */
	void moveHero(int x, int y);

	/**
	 * move the monsters
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
	boolean contactMonster(int x, int y);

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
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 * @throws IOException
	 * 				Can"t read the file.
	 */
	void orderPerform(ControllerOrder controllerOrder) throws IOException;
}
