package contract;

import java.io.IOException;
import java.util.Observer;

public interface IModel {

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	IMap getMap();

	/**
	 * Load the map.
	 *
	 * @param ID the key
	 */
	void loadMap(int ID);


	/**
	 * notify the changes to the view
	 */
	void flush();


	/**
	 * sets the message
	 *
	 * @param message
	 * 				the message to set
	 */
	void setMessage(String message);


	/**
	 * get the message
	 *
	 * @return message
	 */
	String getMessage();


	/**
	 * calls the instantiation of  a spell
	 *
	 * @param path      path of the spell image
	 * @param direction direction that the spell will go
	 * @throws IOException
	 * 			Can't read the file
	 */
	void createSpell(String path) throws IOException;

	/**
	 * Sets the door.
	 *
	 * @param element
	 * 		The element.
	 *
	 */
	
	/**
	 * The closed door becomes open
	 * @return void
	 */
	void setOpenDoor(IElement element);

	/**
	 * Test the element type
	 * @return int
	 */
	int testType(IElement element);
	
	/**
	 * Adds an observer
	 * @return void
	 */
	public void addObserver(Observer o);

	/**
	 * Sets the number of lives
	 * @return void
	 */
	void setResurrections(int resurrections);
	
	/**
	 * Gets the number of lives
	 * @return int
	 */
	int getResurrections();

	/**
	 * Sets the score
	 * @return void
	 */
	void setScore(int i);
	
	/**
	 * Gets the score
	 * @return int
	 */
	int getScore();

}