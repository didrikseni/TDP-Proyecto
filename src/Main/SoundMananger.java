package Main;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundMananger {

	public static synchronized void playSound(final String url) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					InputStream audioSrc = getClass().getResourceAsStream("/Resources/Audio/" + url);
					InputStream bufferedIn = new BufferedInputStream(audioSrc);
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(bufferedIn);
					clip.open(inputStream);
					clip.start(); 
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
	}	
}
