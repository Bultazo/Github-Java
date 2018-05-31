package controller;

import contract.IClock;

public class Clock extends Thread implements IClock {

	private Controller controller;
	private boolean stopped = false;
	private int time = 100;

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
		}
	}

	public boolean isStopped() {
		return stopped;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}
}
