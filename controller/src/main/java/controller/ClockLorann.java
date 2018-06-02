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

	private Controller controller;
	private boolean stopped = false;
	private int time = 70;

	public ClockLorann(Controller controller) {
		this.controller = controller;
	}

	public synchronized void run() {
		while (true) {
			if (controller.getView().isMoving()) {
				try {
					System.out.println(controller.getView().getOrder());
					controller.orderPerform(controller.getView().getOrder());
					controller.getView().setMoving(false);
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

	public boolean isStopped() {
		return stopped;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}
}
