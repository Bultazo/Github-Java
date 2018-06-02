package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import contract.ControllerOrder;
import controller.IController;
import model.IModel;

/**
 * @author DELL
 *
 */
public class ViewFacade implements IView, Runnable, KeyListener {

	/**
	 * The viewFrame
	 */
	private final Frame viewFrame;
	/**
	 * The order
	 */
	private ControllerOrder order;
	/**
	 * The isMoving
	 */
	private boolean isMoving = false;
	
	/**
	 * The main constructor 
	 */
	public ViewFacade(final IModel model) {
		this.viewFrame = new Frame(model);
		this.buildViewFrame();
		SwingUtilities.invokeLater(this);
	}
	
	/**
	 * The Frame's BuildViewFrame Method
	 * 
	 */
	public void buildViewFrame() {
		this.viewFrame.buildViewFrame();
	}
	
	/*
	 * Overrides the run Method in the implemented interface
	 */ 
	public void run() {
		this.viewFrame.addKeyListener(this);
		this.viewFrame.setVisible(true);
	}
	
	
	// Key Listeners 
	
	/*
	 * Overrides the keyPressed Method in the implemented interface
	 */ 
	public void keyPressed(final KeyEvent e) {
		this.isMoving = true;
		this.order = Frame.keyCodeToControllerOrder(e);
	}

	/*
	 * Overrides the keyTyped Method in the implemented interface
	 */ 
	public void keyTyped(final KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/*
	 * Overrides the keyReleased Method in the implemented interface
	 */ 
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		this.isMoving = false;
	}

	
	// Getters and setters 
	
	/*
	 * Overrides the getOrder Method in the implemented interface
	 */ 
	public ControllerOrder getOrder() {
		return order;
	}

	/*
	 * Overrides the isMoving Method in the implemented interface
	 */ 
	public boolean isMoving() {
		return isMoving;
	}

	/*
	 * Overrides the setMoving Method in the implemented interface
	 */ 
	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}
}
