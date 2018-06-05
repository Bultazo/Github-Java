package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Observer;

import javax.swing.*;

import contract.ControllerOrder;
import controller.IController;
import model.IModel;

/**
 * @author DELL
 *
 */
public class Frame extends JFrame {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = -697358409737458175L;
	/**
	 * The model
	 */
	private IModel model;

	/**
	 * The main constructor
	 */
	public Frame(final IModel model) throws HeadlessException {
		this.model = model;
	}

	/**
	 * Builds a frame (Setting size, adding observers etc..)
	 * 
	 */
	void buildViewFrame() {
		this.setTitle("Lorann (BEST GAME EVER)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(660, 425 + 100);
		this.setLocationRelativeTo(null);
		Panel viewPanel = new Panel(this);
		this.model.addObserver(viewPanel);
		this.setContentPane(viewPanel);
		this.setBackground(Color.black);
		this.setVisible(true);
	}

	/**
	 * Converts the KeyCode of the keyListener to an order
	 * 
	 * @return ControllerOrder
	 */
	static ControllerOrder keyCodeToControllerOrder(final KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_Z:
		case KeyEvent.VK_UP:
			return ControllerOrder.UP;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			return ControllerOrder.DOWN;
		case KeyEvent.VK_Q:
		case KeyEvent.VK_LEFT:
			return ControllerOrder.LEFT;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			return ControllerOrder.RIGHT;
		case KeyEvent.VK_SPACE:
			return ControllerOrder.SPACE;
		case KeyEvent.VK_R:
			return ControllerOrder.RETRY;
		case KeyEvent.VK_A:
			return ControllerOrder.UPLEFT;
		case KeyEvent.VK_E:
			return ControllerOrder.UPRIGHT;
		case KeyEvent.VK_W:
			return ControllerOrder.DOWNLEFT;
		case KeyEvent.VK_C:
			return ControllerOrder.DOWNRIGHT;
		}
		return null;
	}

	/**
	 * Gets the Model
	 * 
	 * @return IModel
	 */
	IModel getModel() {
		return this.model;
	}
}
