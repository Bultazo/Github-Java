package view;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.*;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;

/**
 * @author DELL
 *
 */

public class Frame extends JFrame{

	private static final long serialVersionUID = -697358409737458175L;
	private IModel model;

	
	public Frame(final IModel model) throws HeadlessException {
		this.model = model;
		this.buildViewFrame(model);
	}

	private void buildViewFrame(final IModel model) {
		this.setTitle("Lorann (BEST GAME EVER)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(660, 425 + 50); 
		this.setLocationRelativeTo(null);
		Panel viewPanel = new Panel(this);
		
		this.setContentPane(viewPanel);
		this.setBackground(Color.black);
		this.setVisible(true);
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


	IModel getModel() {
		return this.model;
	}
}
