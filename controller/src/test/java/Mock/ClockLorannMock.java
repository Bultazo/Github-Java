/**
 * ClockLorannMock.java
 */
package Mock;

import java.io.IOException;

import controller.Controller;
import controller.IClock;

/**
 * @author DELL
 *
 */
public class ClockLorannMock extends Thread implements IClock {
	/**
	 * The controller
	 */
	private ControllerMock controller;
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
	public ClockLorannMock(ControllerMock controller) {
		this.controller = controller;
	}

	public synchronized void run() {
		while (true) {
			if (controller.getView().isMoving()) {
					try {
						controller.orderPerform(controller.getView().getOrder());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
