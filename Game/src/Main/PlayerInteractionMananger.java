package Main;

import java.awt.event.KeyEvent;
import Entity.Player;
import Entity.PlayerMovement;

public class PlayerInteractionMananger {
	private PlayerMovement playerMovement;
	private Player player;
	
	public PlayerInteractionMananger(Player player) {
		this.player = player;
		this.playerMovement = player.getPlayerMovement();
	}
	
	public void playerStartMove(int keyCode) {
		switch (keyCode){
			case KeyEvent.VK_UP:
				playerMovement.startMove(0); break;
			case KeyEvent.VK_DOWN:
				playerMovement.startMove(1); break;
			case KeyEvent.VK_LEFT:
				playerMovement.startMove(2); break;
			case KeyEvent.VK_RIGHT:
				playerMovement.startMove(3); break;
		}
	}

	public void playerStopMove(int keyCode) {
		switch (keyCode){
			case KeyEvent.VK_UP:
				playerMovement.stopMove(0);  break;
			case KeyEvent.VK_DOWN:
				playerMovement.stopMove(1);	 break;
			case KeyEvent.VK_LEFT:
				playerMovement.stopMove(2);	 break;
			case KeyEvent.VK_RIGHT:
				playerMovement.stopMove(3);  break;
		}
	}	
	
	public void playerShoot(boolean b) {
		player.shoot(b);
	}
}
