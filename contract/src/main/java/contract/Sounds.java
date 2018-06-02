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
public enum Sounds {

	EXPLOSION("Sounds/Explosion.wav"), COIN("Sounds/Powerup.wav"), SPELL("Sounds/Laser.wav"), DOOR("Sounds/Door.wav"), 
	HIT("Sounds/Hit.wav"), GAMEOVER("Sounds/GameOver.wav"), YOUWIN1("Sounds/YouWin1.wav"), YOUWIN2("Sounds/YouWin2.wav");

	private Clip clip;

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

	public void play() {
		if (clip.isRunning()) {
			clip.stop();
		}
		clip.setFramePosition(0);
		clip.start();
	}
	
	public void loop() {
		while(true) {
			clip.loop(1);
		}
	}

	static void init() {
		values();
	}
}
