package controller;

import java.io.IOException;

/**
 * @author DELL
 *
 */

public class Clock extends Thread implements IClock {

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
	private int time = 120;

	/**
	 * The main constructor 
	 */
	public Clock(Controller controller) {
		this.controller = controller;
	}

	/*
	 * Overrides the run Method in 
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
