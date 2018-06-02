/**
 * 
 */
package controller;

import java.io.IOException;

import contract.IClock;

/**
 * @author DELL
 *
 */

public class ClockLorann extends Thread implements IClock {

	/**
	 * The controller
	 */
	private Controller controller;
	/**
	 * The stopped
	 */
	private boolean stopped = false;
	/**
	 * The time
	 */
	private int time = 70;

	/**
	 * The main constructor 
	 */
	public ClockLorann(Controller controller) {
		this.controller = controller;
	}

	/*
	 * Overrides the run Method 
	 */ 
	public synchronized void run() {
		while (true) {
			if (controller.getView().isMoving()) {
				try {
					controller.orderPerform(controller.getView().getOrder());
			
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (!stopped) {
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				controller.updateSprite();
			}

		}

	}

	/*
	 * Overrides the isStopped Method
	 */ 
	public boolean isStopped() {
		return stopped;
	}

	/*
	 * Overrides the setStopped Method
	 */ 
	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}
}
