package Animations;

import javax.swing.Icon;
import javax.swing.JLabel;

import GUI.GUI_Game;

public class AnimationMananger {
	private static AnimationMananger INSTANCE = null;
	private static GUI_Game gui;
		
	private AnimationMananger() {
		gui = GUI_Game.getInstance();
	}
	
	public synchronized static AnimationMananger getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AnimationMananger();
		}
		return INSTANCE;
	}
	
	public void addAnimation(Icon[] arr, int x, int y) {
		Animation animation;
		JLabel animacion = new JLabel();
		
		gui.add(animacion);
		gui.addComponentInLayer(animacion, 25);
		animation = new Animation(arr, animacion);
		animacion.setBounds(x, y, arr[0].getIconWidth(), arr[0].getIconHeight());
		animacion.setVisible(true);
		animation.start();
	}	

	public static void remove(JLabel label) {
		gui.remove(label);
	}
	
}
