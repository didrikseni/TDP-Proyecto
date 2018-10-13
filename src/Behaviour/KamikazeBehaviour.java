package Behaviour;

import java.awt.Point;
import Entity.Enemy;
import Entity.Player;
import GUI.GUI_Game;

public class KamikazeBehaviour extends Behaviour {
	//Attributes
	private Player player;
	private long delay;
	private long elapsedTime;
	
	public KamikazeBehaviour() {
		player = Player.getInstance(0,0,null);
		elapsedTime = System.nanoTime();
		delay =  500000000;
	}
	
	public void update(Enemy e) {
		super.update(e);
		Point p = e.getPos();
		GUI_Game gui = GUI_Game.getInstance();
		e.startMove(1);
		if(System.nanoTime() - elapsedTime > delay) {
			int playerX = player.getPos().x;
			if(playerX < p.x) {
				e.stopMove(3);
				e.startMove(2);
			} else if(playerX > p.y){
				e.stopMove(2);
				e.startMove(3);
			} else {
				e.stopMove(3);
				e.stopMove(2);
			}
			elapsedTime = System.nanoTime();
		}
		if(p.y > (gui.getHeight() - e.getHeight() - 40)) {
			e.setPos(p.x, 0); 
		}
	}
	
}
