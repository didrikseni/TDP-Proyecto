package Behaviour;

import java.awt.Point;

import Entity.Enemy;
import Entity.Player;
import Main.GUI;

public class KamikazeBehaviour extends Behaviour {
	//Attributes
	private static KamikazeBehaviour INSTANCE = null;

	private static Player player;
	private static long delay;
	private static long elapsedTime;
	
	private KamikazeBehaviour() {
		player = Player.getInstance(0,0,null);
		elapsedTime = System.nanoTime();
		delay =  500000000;
	}
	
	public static KamikazeBehaviour getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new KamikazeBehaviour();
		}
		return INSTANCE;
	}
	
	public void update(Enemy e) {
		super.update(e);
		Point p = e.getPos();
		GUI gui = GUI.getInstance();
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
		if(p.y > (gui.getAlto() - e.getHeight() - 40)) {
			e.setPos(p.x, 0); 
		}
	}
	
}
