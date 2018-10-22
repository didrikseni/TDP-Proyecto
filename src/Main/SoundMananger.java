package Main;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundMananger {

	public static synchronized void playSound(final String url) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					InputStream audioSrc = getClass().getResourceAsStream("/Resources/Audio/" + url);
					InputStream bufferedIn = new BufferedInputStream(audioSrc);
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(bufferedIn);
					clip.open(inputStream);
					FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
					volume.setValue(-20.0f);
					clip.start(); 					
				} catch (Exception e) {}
			}
		});
		thread.start();
	}
	
	public static synchronized Thread playLoopSound(final String url) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					InputStream audioSrc = getClass().getResourceAsStream("/Resources/Audio/" + url);
					InputStream bufferedIn = new BufferedInputStream(audioSrc);
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(bufferedIn);
					clip.open(inputStream);
					FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
					volume.setValue(-25.0f);
					clip.start(); 
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				} catch (Exception e) {}
			}
		});
		thread.start();
		return thread;
	}

}
