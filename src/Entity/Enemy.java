package Entity;

import Game.Game;
import Intelligence.DefaultIntelligence;
import Intelligence.Intelligence;
import PowerUp.PowerUp;
import PowerUp.WeaponUpgrade1;

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
			java.util.Random rnd = new java.util.Random();
			if (rnd.nextInt(100) < 7) {
				PowerUp powerUp = new WeaponUpgrade1(pos.x, pos.y, game);
				game.addEntity(powerUp);
			}
			game.imDead(this, score);
		}
	}
}
