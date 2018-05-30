package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.*;

import contract.IController;
import contract.IModel;

public class ViewFrame extends JFrame implements KeyListener {

	private IModel model;

	private IController controller;

	private static final long serialVersionUID = -697358409737458175L;

	ViewFrame(final IModel model) throws HeadlessException {
		this.model = model;
		this.buildViewFrame(model);
	}

	private IController getController() {
		return this.controller;
	}

	void setController(final IController controller) {
		this.controller = controller;
	}

	IModel getModel() {
		return this.model;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}

	private void buildViewFrame(final IModel model) {
		this.setTitle("LORANN");
		this.setModel(model);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setSize(660, 425 + 30); // Size of the map plus scoring panel
		this.setLocationRelativeTo(null);
		ViewPanel viewPanel = new ViewPanel(this);

		this.setContentPane(viewPanel);
		this.setBackground(Color.black);
		this.setVisible(true);

	}

	public void keyTyped(final KeyEvent e) {

	}

	public void keyPressed(final KeyEvent e) {
		try {
			this.getController().orderPerform(View.keyCodeToControllerOrder(e));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void keyReleased(final KeyEvent e) {

	}
}
