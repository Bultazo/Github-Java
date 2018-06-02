
package controller;

import model.IModel;
import view.IView;

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
	 * 
	 */
	public void start() {
		this.controller.start();
	}

	/**
	 * The controller's updateController method
	 * 
	 */
	public synchronized void updateController() {
		this.controller.updateController();
	}

	/**
	 * The controller's updateSprite method
	 * 
	 */
	public void updateSprite() {
		this.controller.updateSprite();
	}

}
