package Mock;

import contract.ControllerOrder;
import controller.IController;
import view.IView;


public class ViewMock {

    public ViewMock() {
    }

    public void setController(IController controller) {

    }

	/*
	 * Overrides the getOrder Method in the implemented interface
	 * @return
	 */ 

	public ControllerOrder getOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Overrides the isMoving Method in the implemented interface
	 * @return
	 */ 

	public boolean isMoving() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Overrides the setMoving Method in the implemented interface
	 * @param isMoving
	 */ 

	public void setMoving(boolean isMoving) {
		// TODO Auto-generated method stub
		
	}
}
