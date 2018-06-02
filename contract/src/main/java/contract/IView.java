package contract;

/**
 * The Interface IView.
 *
 * @author DELL
 */
public interface IView {

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	void setController(final IController controller);
	
	ControllerOrder getOrder();
	
	boolean isMoving();
}
