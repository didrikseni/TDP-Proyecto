package Entity;

import Game.Game;
import Intelligence.DefectIntelligence;
import Intelligence.Intelligence;

public abstract class Enemy extends Entity {
	//Attributes
	protected Intelligence intel;
	
	
	protected Enemy(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
		intel = DefectIntelligence.getInstance();
	}

	public void update() {
		super.update();
		intel.update(this);
	}

}
