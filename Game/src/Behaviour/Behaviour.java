package Behaviour;

import Entity.Enemy;
import GUI.GUI_Game;

public abstract class Behaviour {

	public void update(Enemy enemy) {
		GUI_Game gui = GUI_Game.getInstance();
		if(enemy.getPos().y > gui.getHeight()) {
			enemy.setPos(enemy.getPos().x, - enemy.getHeight()); 
		}	
	}
	
	public abstract void changeBehaviour(Enemy enemy);
	
}
