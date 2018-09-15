package Intelligence;

import java.awt.Point;

import Entity.Enemy;
import Main.GUI;

public abstract class Intelligence {

	public void update(Enemy e) {
		Point p = e.getPos();
		GUI g = e.getGame().getGUI();
		
		if (p.y > g.getHeight()) {
			p.setLocation(p.x, 0);
		}
		
	}
	
}
