package Behaviour;

import java.awt.Point;

import Entity.Enemy;
import GUI.GUI_Game;

public abstract class Behaviour {

	public void update(Enemy e) {
		Point p = e.getPos();
		GUI_Game g = GUI_Game.getInstance();		
		if (p.y > g.getAlto()) {
			p.setLocation(p.x, 0);
		}
		
	}
	
}
