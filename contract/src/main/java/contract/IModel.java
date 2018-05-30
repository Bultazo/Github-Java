package contract;

import java.io.IOException;
import java.util.Observable;

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
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	/**
	 * notify the changes to the view
	 */
	void flush();


	/**
	 * test the type of element
	 *
	 * @param element
	 * 				the element
	 * @return int representing an element
	 */
	int testType(IElement element);


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
	void createSpell(String path, ControllerOrder direction) throws IOException;

	/**
	 * Sets the door.
	 *
	 * @param element
	 * 		The element.
	 *
	 */
	void setDoor(IElement element);

}