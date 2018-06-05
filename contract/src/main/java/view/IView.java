package view;

import contract.ControllerOrder;

/**
 * The Interface IView.
 *
 * @author DELL
 */
/**
 * @author DELL
 *
 */
public interface IView {
	
	/**
	 * Gets the order
	 * @return
	 */
	ControllerOrder getOrder();
	
	/**
	 * Checks if is moving
	 * @return
	 */
	boolean isMoving();
	
	/**
	 * Sets is moving d
	 * @param isMoving
	 */
	void setMoving(boolean isMoving); 
}
