package Behaviour;

import java.awt.Point;
import java.util.Random;

import Entity.Enemy;
import Entity.Player;
import Main.GUI;

public class DefaultBehaviour extends Behaviour {
	//Attributes
	private static DefaultBehaviour INSTANCE = null;

	private static boolean right;
	private static Random rnd;
	
	private DefaultBehaviour() {
		right = true;
		rnd = new Random();
	}
	
	public static DefaultBehaviour getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new DefaultBehaviour();
		}
		return INSTANCE;
	}
	
	public void update(Enemy e) {
		super.update(e);
		Point pos = e.getPos();
		GUI gui = GUI.getInstance();
		Player player = Player.getInstance(0, 0, null);
		if(rnd.nextInt(10) < 4 && inRange(player, pos)) {
			e.shoot();
		}
		if (right) {
			e.stopMove(2);
			e.startMove(3);
			if (pos.x >= gui.getAncho() - e.getGraphics().getWidth() - 15) {
				right = false;
				e.stopMove(3);
			}
			//e.setPos(pos.x, (int) (pos.y + Math.cos(pos.x / 20)));
		} else {
			e.stopMove(3);
			e.startMove(2);
			if (pos.x <= 0) {
				right = true;
				e.stopMove(2);
			}
			//e.setPos(pos.x, (int) (pos.y + 3 * Math.sin(pos.x / 20)));
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
