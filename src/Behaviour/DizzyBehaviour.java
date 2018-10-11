package Behaviour;

import java.awt.Point;
import java.util.Random;

import Entity.Enemy;
import GUI.GUI_Game;

public class DizzyBehaviour extends Behaviour {
	private long delay;
	private long elapsedTime;
	private Random rnd;
	
	public DizzyBehaviour() {
		delay = 500000000;
		rnd = new Random();
		elapsedTime = System.nanoTime();
	}
	
	public void update(Enemy e) {
		super.update(e);
		Point p = e.getPos();
		GUI_Game gui = GUI_Game.getInstance();
		if(System.nanoTime() - elapsedTime > delay) {
			e.stopMove(0);
			e.stopMove(2);
			e.stopMove(3);
			e.startMove(rnd.nextInt(4));
			e.startMove(rnd.nextInt(4));
			elapsedTime = System.nanoTime();
		}
		if(p.y > (gui.getAlto() - e.getHeight() - 40)) {
			e.setPos(p.x, 0); 
		}
	}
}
