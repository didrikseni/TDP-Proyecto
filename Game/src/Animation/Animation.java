package Animation;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Animation implements Runnable {
	protected Icon [] array;
	protected JLabel label;
	protected AnimationMananger aMananger = AnimationMananger.getInstance();

	protected Animation(int x, int y, int width, int height) {
		label = new JLabel();
		label.setBounds(x, y, width, height);
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
				Thread.sleep(25);
			} catch (Exception e) {}	
		}
		AnimationMananger.remove(label);
	}

	public JLabel getLabel() {
		return label;
	}
}
