package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInteractionThread implements Runnable, KeyListener {
	private GUI gui;
	private boolean isRunning;
	
	public PlayerInteractionThread(GUI gui) {
		this.gui = gui;
	}

	public void terminate() {
		isRunning = false;		
	}
	
	@Override
	public void run() {
		isRunning = true;
		while(isRunning) {
			
		}
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

	@Override
	public void keyTyped(KeyEvent arg0) {
			
	}
	
	
}
