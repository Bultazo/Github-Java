/**
 * 
 */
package controller;

import contract.IClock;

/**
 * @author DELL
 *
 */
public class ClockAnimation extends Thread implements IClock {
	private Controller controller;
	private boolean stopped = false;
	private int time = 100;
	
	public ClockAnimation(Controller controller) {
		this.controller = controller;
	}

	public synchronized void run() {
		while (!stopped) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			controller.updateSprite();
		}
	}

	public boolean isStopped() {
		return stopped;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

}
