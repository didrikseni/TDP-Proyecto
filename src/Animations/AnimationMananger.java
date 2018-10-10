package Animations;

import javax.swing.Icon;
import javax.swing.JLabel;
import Main.GUI;

public class AnimationMananger {
	private static AnimationMananger INSTANCE = null;
	private static GUI gui;
		
	private AnimationMananger() {
		gui = GUI.getInstance();
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
