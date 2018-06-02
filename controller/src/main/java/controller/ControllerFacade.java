/**
 * 
 */
package controller;

import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * @author DELL
 *
 */
public class ControllerFacade {

	private IController controller;

	public ControllerFacade(IView view, IModel model) {
		this.controller = new Controller(view, model);
		this.start();
	}

	public void start() {
		this.controller.start();
	}

	public synchronized void updateController() {
		this.controller.updateController();
	}

	public void updateSprite() {
		this.controller.updateSprite();
	}

}
