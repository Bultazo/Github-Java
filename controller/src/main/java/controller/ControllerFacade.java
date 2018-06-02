
package controller;

import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * @author DELL
 *
 */
public class ControllerFacade {

	/**
	 * The controller
	 */
	private IController controller;

	/**
	 * The main constructor 
	 */
	public ControllerFacade(IView view, IModel model) {
		this.controller = new Controller(view, model);
		this.start();
	}

	/**
	 * The controller's start method
	 * @return void
	 */
	public void start() {
		this.controller.start();
	}

	/**
	 * The controller's updateController method
	 * @return void
	 */
	public synchronized void updateController() {
		this.controller.updateController();
	}

	/**
	 * The controller's updateSprite method
	 * @return void
	 */
	public void updateSprite() {
		this.controller.updateSprite();
	}

}
