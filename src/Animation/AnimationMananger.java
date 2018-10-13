package Animation;

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
	
	public void addAnimation(Animation animation, JLabel label) {
		gui.add(label);
		gui.addComponentInLayer(label, 25);
		label.setVisible(true);
		Thread asd = new Thread(animation);
		asd.start();
	}	

	public static void remove(JLabel label) {
		gui.remove(label);
	}
	
}