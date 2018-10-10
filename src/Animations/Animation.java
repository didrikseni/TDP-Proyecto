package Animations;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Animation extends Thread {
	private static Icon [] array;
	private long delay;
	private JLabel label;
	
	
	public Animation(Icon[] arr, int x, int y, long delay, JLabel label) {
		array = arr;
		this.delay = delay;
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
				Thread.sleep(waitTime);
			} catch (Exception e) {}	
		}
		this.interrupt();
	}	
}
