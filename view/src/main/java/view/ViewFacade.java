package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;


import javax.swing.SwingUtilities;
import javax.swing.Timer;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

public class ViewFacade implements IView, Runnable, KeyListener {

	private final Frame viewFrame;
	private IController controller;
	private ControllerOrder order;
	private boolean isMoving = false;
	
	public ViewFacade(final IModel model) {
		this.viewFrame = new Frame(model);
		SwingUtilities.invokeLater(this);
	}

	public void run() {
		this.viewFrame.addKeyListener(this);
		this.viewFrame.setVisible(true);
	}

	public void keyPressed(final KeyEvent e) {
		setMoving(true);
		this.order = Frame.keyCodeToControllerOrder(e);
	}
	public ControllerOrder getOrder() {
		return order;
	}

	public void keyTyped(final KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		setMoving(false);
	}

	public void setController(final IController controller) {
		this.controller = controller;
	}

	public boolean isMoving() {
		return isMoving;
	}

	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

}
