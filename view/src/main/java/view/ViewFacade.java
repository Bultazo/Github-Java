package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.SwingUtilities;
import contract.IController;
import contract.IModel;
import contract.IView;

public class ViewFacade implements IView, Runnable, KeyListener {

	private final Frame viewFrame;
	private IController controller;

	public ViewFacade(final IModel model) {
		this.viewFrame = new Frame(model);
		SwingUtilities.invokeLater(this);
	}

	public void run() {
		this.viewFrame.addKeyListener(this);
		this.viewFrame.setVisible(true);
	}

	public void keyPressed(final KeyEvent e) {
		try {
			this.controller.orderPerform(Frame.keyCodeToControllerOrder(e));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void keyTyped(final KeyEvent e) {
		// NOP
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void setController(final IController controller) {
		this.controller = controller;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */

}
