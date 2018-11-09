package Sound;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundMananger implements Runnable {
	private Clip clip;
	private String url;
	private int loopCount;

	public SoundMananger(String url) {
		this.url = url;
		this.clip = null;
	}
	
	public void playSound() {
		loopCount = 1;
		this.run();
	}
	
	public void playLoopSound() {
		loopCount = Clip.LOOP_CONTINUOUSLY;
		this.run();
		FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(-10.0f);
	}
	
	@Override
	public void run() {
		try {
			clip = AudioSystem.getClip();
			InputStream audioSrc = getClass().getResourceAsStream("/Resources/Audio/" + url);
			InputStream bufferedIn = new BufferedInputStream(audioSrc);
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(bufferedIn);
			clip.open(inputStream);			
			clip.start(); 			
			clip.loop(loopCount);
		} catch (Exception e) {}
	}
	
	public Clip getClip() {
		return clip;
	}
}
