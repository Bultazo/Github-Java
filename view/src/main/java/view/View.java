package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import javafx.scene.input.KeyCode;


public class View implements IView, Runnable {

	
	private final ViewFrame viewFrame;

	
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	
	static ControllerOrder keyCodeToControllerOrder(final KeyEvent keyCode) {
		switch (keyCode.getKeyCode()) {

				case KeyEvent.VK_UP:
				case KeyEvent.VK_Z:
					return ControllerOrder.UP;
				case KeyEvent.VK_DOWN:
				case KeyEvent.VK_S:
					return ControllerOrder.DOWN;
				case KeyEvent.VK_LEFT:
				case KeyEvent.VK_Q:
					return ControllerOrder.LEFT;
				case KeyEvent.VK_RIGHT:
				case KeyEvent.VK_D:
					return ControllerOrder.RIGHT;
				case KeyEvent.VK_SPACE:
					return ControllerOrder.SPACE;

				case KeyEvent.VK_R:
					return ControllerOrder.RETRY;

			}
		return null;
	}


	
	public void run() {
		this.viewFrame.setVisible(true);
	}

	
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
