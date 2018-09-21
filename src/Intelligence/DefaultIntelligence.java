package Intelligence;

import java.awt.Point;
import Entity.Enemy;
import Main.GUI;

public class DefaultIntelligence extends Intelligence{
	//Attributes
	private static DefaultIntelligence INSTANCE = null;

	private static boolean right;
	
	private DefaultIntelligence() {
		right = true;
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
		GUI g = GUI.getInstance();
		if (right) {
			e.stop(2);
			e.move(3);
			if (p.x >= g.getAncho() - e.getGraphics().getWidth() - 15) {
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
	
}
