package GUI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyListener extends KeyAdapter {
	private GUI_Game gui;
	
	public KeyListener(GUI_Game gui) {
		this.gui = gui;
	}

	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			gui.shoot(true);
		}
		gui.playerStartMove(arg0);
	}

	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			gui.shoot(false);
		}
		gui.playerStopMove(arg0);
	}
}
