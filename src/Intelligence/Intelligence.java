package Intelligence;

import java.awt.Point;

import Entity.Enemy;
import Main.GUI;

public abstract class Intelligence {

	public void update(Enemy e) {
		Point p = e.getPos();
		GUI g = GUI.getInstance();		
		if (p.y > g.getAlto()) {
			p.setLocation(p.x, 0);
		}
		
	}
	
}
