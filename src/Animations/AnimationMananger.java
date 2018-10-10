package Animations;

import javax.swing.Icon;
import javax.swing.JLabel;
import Main.GUI;

public class AnimationMananger {
	private static AnimationMananger INSTANCE = null;
	private GUI gui;
		
	private AnimationMananger() {
		this.gui = GUI.getInstance();
	}
	
	public synchronized static AnimationMananger getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AnimationMananger();
		}
		return INSTANCE;
	}
	
	public void addAnimation(Icon[] arr, int x, int y) {
		Thread animation;
		JLabel animacion = new JLabel();
		
		gui.add(animacion);
		animation = new Animation(arr, x, y, 16666, animacion);
		animacion.setSize(arr[0].getIconWidth(), arr[0].getIconHeight());
		animacion.setVisible(true);
		animation.start();
		while (!Thread.interrupted()) {}
		gui.remove(animacion);
	}	
	
}
