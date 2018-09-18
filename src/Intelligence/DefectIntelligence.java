package Intelligence;

import java.awt.Point;
import Entity.Enemy;
import Main.GUI;

public class DefectIntelligence extends Intelligence{
	//Attributes
	private static DefectIntelligence INSTANCE = null;

	private static boolean right;
	
	private DefectIntelligence() {
		right = true;
	}
	
	public static DefectIntelligence getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new DefectIntelligence();
		}
		return INSTANCE;
	}
	
	public void update(Enemy e) {
		super.update(e);
		Point p = e.getPos();
		GUI g = e.getGame().getGUI();
		
		if (right) {
			e.stop(2);
			e.move(3);
			if (p.x >= g.getWidth() - e.getGraphics().getWidth() - 15) {
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
