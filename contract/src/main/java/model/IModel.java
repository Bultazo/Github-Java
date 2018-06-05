package model;

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
	 * 		The open door to set.
	 *
	 */
	
	/**
	 * The closed door becomes open
	 * 
	 */
	void setOpenDoor(IElement element);

	/**
	 * Test the element type
	 * @param element 
	 * @return int
	 * 
	 */
	int testType(IElement element);
	
	/**
	 * Adds an observer
	 * @param o 
	 * 
	 */
	public void addObserver(Observer o);

	/**
	 * Sets the number of lives
	 * @param resurrections
	 *       the Resurrections to set.
	 *          
	 * 
	 */
	void setResurrections(int resurrections);
	
	/**
	 * Gets the number of lives
	 * @return int
	 */
	int getResurrections();

	/**
	 * Sets the score
	 * @param i
	 */
	void setScore(int i);
	
	/**
	 * Gets the score
	 * @return int
	 */
	int getScore();

}