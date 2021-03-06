/**
 * ClockMock.java
 */
package Mock;

import controller.IClock;

/**
 * @author DELL
 *
 */
/**
 * @author DELL
 *
 */
public class ClockMock extends Thread implements IClock {

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
	private int time = 100;

	/**
	 * The main constructor
	 * 
	 * @param controller
	 */
	public ClockMock(ControllerMock controller) {
		this.controller = controller;
	}

	/*
	 * This updates the controller's Monster AI and the spell movements
	 */
	public synchronized void run() {
		while (!stopped) {
			controller.updateController();
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/*
	 * Overrides the isStopped Method in the implemented interface
	 * 
	 * @return
	 */
	public boolean isStopped() {
		return stopped;
	}

	/*
	 * Overrides the setStopped Method in the implemented interface
	 * 
	 * @param stopped
	 */
	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}
}

