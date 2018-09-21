package Entity;

import Game.Game;
import Intelligence.DefaultIntelligence;
import Intelligence.Intelligence;

public abstract class Enemy extends Entity {
	//Attributes
	protected Intelligence intel;
	protected int score;
	
	
	protected Enemy(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
		intel = DefaultIntelligence.getInstance();
	}

	@Override
	public void update() {
		super.update();
		intel.update(this);
	}

	@Override
	public void takeDamage(int damage) {
		if (damage >= 0) {
			life -= damage; 
		}
		if(life <= 0) {
			g.mori(this, score);
		}
	}
}
