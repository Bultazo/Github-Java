/**
 * 
 */
package contract;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

/**
 * @author DELL
 *
 */
/**
 * @author DELL
 *
 */
public enum Sounds {

	/**
	 * The EXPLOSION
	 */
	EXPLOSION("Sounds/Explosion.wav"),
	/**
	 * The COIN
	 */
	COIN("Sounds/Coin.wav"),
	/**
	 * The SPELL
	 */
	SPELL("Sounds/Laser.wav"),
	/**
	 * The DOOR
	 */
	DOOR("Sounds/Door.wav"),
	/**
	 * The HIT
	 */
	HIT("Sounds/Hit.wav"),
	/**
	 * The GAMEOVER
	 */
	GAMEOVER("Sounds/GameOver.wav"),
	/**
	 * The YOUWIN1
	 */
	DOOROPEN("Sounds/DoorOpen.wav"),
	/**
	 * The YOUWIN2
	 */
	YOUWIN2("Sounds/YouWin2.wav");

	/**
	 * The clip
	 */
	private Clip clip;

	/**
	 * The main constructor for Sounds
	 * @param soundFileName
	 */
	Sounds(String soundFileName) {
		try {
			File f = new File(soundFileName);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Plays the clip
	 * 
	 */
	public void play() {
		stop();
		clip.setFramePosition(0);
		clip.start();
	}

	/**
	 * Loops the clip
	 * 
	 */
	public void loop() {
		while (true) {
			clip.loop(1);
		}
	}
	
	/**
	 * Stops the clip
	 */
	public void stop() {
		if (clip.isRunning()) {
			clip.stop();
		}
	}

	/**
	 * Initialize all the values
	 * 
	 */
	static void init() {
		values();
	}
}
