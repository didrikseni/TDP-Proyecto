package Animations;

import javax.swing.Icon;
import javax.swing.JLabel;

import Entity.Player;

public abstract class Animation implements Runnable {
	protected Icon [] array;
	protected JLabel label;
	protected AnimationMananger aMananger = AnimationMananger.getInstance();
	
	public Animation(int x, int y) {
		label = new JLabel();
		label.setBounds(x, y, 40, 40);
		loadImages();
	}

	public abstract void loadImages();
	
	public void getStarted() {
		aMananger.addAnimation(this, label);
	}
	
	public void run() {
		int i = 0;
		while(i < array.length) {	
			
			label.setIcon(array[i]);
			label.repaint();
			i++;
			
			try { 
				Thread.sleep(10);
			} catch (Exception e) {}	
		}
		AnimationMananger.remove(label);
	}

	public JLabel getLabel() {
		return label;
	}
}
