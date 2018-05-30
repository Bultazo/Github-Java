package controller;

import contract.IClock;

public class Clock extends Thread implements IClock {

	private Controller controller;

	private boolean stopped = false;

	private int time = 75;

	public Clock(Controller controller) {
		this.controller = controller;
	}

	public synchronized void run() {

		while (!stopped) {
			controller.updateController();

			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			controller.updateSprite();
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			controller.updateSprite();
			try {
				Thread.sleep(100);
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
