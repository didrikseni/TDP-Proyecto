package Behaviour;

import java.awt.Point;

import Entity.Enemy;
import GUI.GUI_Game;

public abstract class Behaviour {

	public void update(Enemy e) {
		Point pos = e.getPos();
		GUI_Game gui = GUI_Game.getInstance();		
		if(pos.y > (gui.getHeight() + e.getHeight() / 2)) {
			e.setPos(pos.x, - e.getHeight()); 
		}
		
	}
	
}
