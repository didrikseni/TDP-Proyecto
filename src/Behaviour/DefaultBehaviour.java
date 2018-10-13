package Behaviour;

import java.awt.Point;
import java.util.Random;

import Entity.Enemy;
import Entity.Player;
import GUI.GUI_Game;

public class DefaultBehaviour extends Behaviour {
	private static DefaultBehaviour INSTANCE;
	
	private static boolean right;
	private static Random rnd;
	
	public DefaultBehaviour() {
		right = true;
		rnd = new Random();
	}
	
	public void update(Enemy e) {
		super.update(e);
		Point pos = e.getPos();
		GUI_Game gui = GUI_Game.getInstance();
		Player player = Player.getInstance(0,0,null);
		if(rnd.nextInt(10) < 1 && inRange(player, pos)) {
			e.shoot();
		}
		if (right) {
			e.getRectangle().x += e.getSpeed(); 
			if (pos.x >= gui.getWidth() - e.getGraphics().getWidth() - 15) {
				right = false;
			}
		} else {
			e.getRectangle().x -= e.getSpeed(); 
			if (pos.x <= 0) {
				right = true;				
			}
		}
		e.getRectangle().y = (int) (15 * Math.sin(e.getPos().x * 0.5 * Math.PI / 120) + e.getPosOriginalY());
		if(pos.y > (gui.getHeight() - e.getHeight() - 40)) {
			e.setPos(pos.x, 0); 
		}
		if (rnd.nextInt(100000) < 10) {
			e.setComportamiento(new KamikazeBehaviour());
		}
	}
	
	private boolean inRange(Player player, Point p) {
		double distancia = Math.sqrt(player.getPos().x * player.getPos().x - p.x * p.x);
		if (distancia <= player.getWidth() && distancia >= 0) {
			return true;
		}
		return false;
	}

	public static DefaultBehaviour getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DefaultBehaviour();
		}
		return INSTANCE;
	}
}

