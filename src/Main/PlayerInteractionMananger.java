package Main;

import java.awt.event.KeyEvent;
import Entity.Player;

public class PlayerInteractionMananger {
	private Player player;
	
	public PlayerInteractionMananger(Player player) {
		this.player = player;
	}
	
	public void playerStartMove(int keyCode) {
		switch (keyCode){
			case KeyEvent.VK_UP:
				player.startMove(0); break;
			case KeyEvent.VK_DOWN:
				player.startMove(1); break;
			case KeyEvent.VK_LEFT:
				player.startMove(2); break;
			case KeyEvent.VK_RIGHT:
				player.startMove(3); break;
		}
	}

	public void playerStopMove(int keyCode) {
		switch (keyCode){
			case KeyEvent.VK_UP:
				player.stopMove(0);  break;
			case KeyEvent.VK_DOWN:
				player.stopMove(1);	 break;
			case KeyEvent.VK_LEFT:
				player.stopMove(2);	 break;
			case KeyEvent.VK_RIGHT:
				player.stopMove(3);  break;
		}
	}	
	
	public void playerShoot(boolean b) {
		player.shoot(b);
	}

}
