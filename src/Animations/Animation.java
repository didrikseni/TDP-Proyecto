package Animations;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Animation extends Thread {
	private static Icon [] array;
	private static long delay = 10;
	private JLabel label;
	
	public Animation(Icon[] arr, JLabel label) {
		array = arr;
		this.label = label;
	}

	public void start() {
		long startTime = 0;
		long elapsedTime = 0;
		long waitTime = 0;
		int i = 0;
		
		while(i < array.length) {
			startTime = System.nanoTime();
			
			label.setIcon(array[i]);
			label.repaint();
			i++;
			
			elapsedTime = (System.nanoTime() - startTime) / 1000000;
			waitTime = delay - elapsedTime;
			try { 
				sleep(waitTime);
			} catch (Exception e) {}	
		}
		this.interrupt();
		AnimationMananger.remove(label);
	}
}
