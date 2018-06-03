/**
 * 
 */
package controller;

import java.io.IOException;

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
	 * @param controller
	 * 		The controller
	 */
	public ClockLorann(Controller controller) {
		this.controller = controller;
	}

	/*
	 * So this needs to be explained : The thing is, the Keylistener implemented in the view have a certain unwanted behavior
	 * Everytime, it waits half a second before it begins repeating the key (when hold) just like typing it in a text bar.
	 * So, to avoid this problem, we have set up the keyPressed to activate a trigger (isMoving) and translate the keycode to an order, 
	 * and we set up the keyReleased to disable it.
	 * Then we created a thread that verified this trigger and if in case it was active, it would retrieve the value of the order 
	 * and call the method within the controller, this will let this thread decide the speed of lorann instead of the keyListener thread.
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
