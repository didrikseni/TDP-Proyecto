package Intelligence;

import java.awt.Point;

import Entity.Enemy;
import Entity.Player;
import Main.GUI;

public class KamikazeIntelligence extends Intelligence {
	//Attributes
	private static KamikazeIntelligence INSTANCE = null;

	private static Player player;
	private static long delay;
	private static long elapsedTime;
	
	private KamikazeIntelligence() {
		player = Player.getInstance(0,0,null);
		elapsedTime = System.nanoTime();
		delay =  500000000;
	}
	
	public static KamikazeIntelligence getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new KamikazeIntelligence();
		}
		return INSTANCE;
	}
	
	public void update(Enemy e) {
		super.update(e);
		Point p = e.getPos();
		GUI gui = GUI.getInstance();
		e.move(1);
		if(System.nanoTime() - elapsedTime > delay) {
			int playerX = player.getPos().x;
			if(playerX < p.x) {
				e.stop(3);
				e.move(2);
			} else if(playerX > p.y){
				e.stop(2);
				e.move(3);
			} else {
				e.stop(3);
				e.stop(2);
			}
			elapsedTime = System.nanoTime();
		}
		if(p.y > (gui.getAlto() - e.getHeight() - 40)) {
			e.setPos(p.x, 0); 
		}
	}
	
}
