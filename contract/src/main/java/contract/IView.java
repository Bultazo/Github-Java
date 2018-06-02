package contract;

/**
 * The Interface IView.
 *
 * @author DELL
 */
public interface IView {
	
	ControllerOrder getOrder();
	
	boolean isMoving();
	
	void setMoving(boolean isMoving); 
}
