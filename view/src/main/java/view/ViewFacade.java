package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

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
		this.buildViewFrame();
		
		SwingUtilities.invokeLater(this);
	}
	
	public void buildViewFrame() {
		this.viewFrame.buildViewFrame();
	}
	
	public void run() {
		this.viewFrame.addKeyListener(this);
		this.viewFrame.setVisible(true);
	}
	
	
	// Key Listeners 
	
	public void keyPressed(final KeyEvent e) {
		setMoving(true);
		this.order = Frame.keyCodeToControllerOrder(e);
	}

	public void keyTyped(final KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	// Getters and setters 
	
	public ControllerOrder getOrder() {
		return order;
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
