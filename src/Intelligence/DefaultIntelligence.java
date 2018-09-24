package Intelligence;

import java.awt.Point;
import java.util.Random;

import Entity.Enemy;
import Entity.Player;
import Main.GUI;

public class DefaultIntelligence extends Intelligence{
	//Attributes
	private static DefaultIntelligence INSTANCE = null;

	private static boolean right;
	private static Random rnd;
	
	private DefaultIntelligence() {
		right = true;
		rnd = new Random();
	}
	
	public static DefaultIntelligence getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new DefaultIntelligence();
		}
		return INSTANCE;
	}
	
	public void update(Enemy e) {
		super.update(e);
		Point p = e.getPos();
		GUI gui = GUI.getInstance();
		Player player = Player.getInstance(0, 0, null);
		if(rnd.nextInt(10) < 4 && inRange(player, p)) {
			e.shoot();
		}
		if (right) {
			e.stop(2);
			e.move(3);
			if (p.x >= gui.getAncho() - e.getGraphics().getWidth() - 15) {
				right = false;
				e.stop(3);
			}
		} else {
			e.stop(3);
			e.move(2);
			if (p.x <= 0) {
				right = true;
				e.stop(2);
			}
		}
	}

	private boolean inRange(Player player, Point p) {
		double distancia = Math.sqrt(player.getPos().x * player.getPos().x - p.x * p.x);
		if (distancia <= player.getWidth() && distancia >= 0) {
			return true;
		}
		return false;
	}
	
}
