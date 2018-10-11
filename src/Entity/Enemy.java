package Entity;

import Behaviour.Behaviour;
import Behaviour.DefaultBehaviour;
import Main.Game;
import PowerUp.PowerUp;
import PowerUp.WeaponUpgrade1;

public abstract class Enemy extends Entity {
	//Attributes
	protected Behaviour comportamiento;
	protected int score;
	protected int originalY;
	
	protected Enemy(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
		originalY = y;
		comportamiento = DefaultBehaviour.getInstance();
	}

	@Override
	public void update() {
		super.update();
		comportamiento.update(this);
	}

	@Override
	public void takeDamage(int damage) {
		if (damage >= 0) {
			life -= damage; 
		}
		if(life <= 0) {
			java.util.Random rnd = new java.util.Random();
			if (rnd.nextInt(100) < 7) {
				PowerUp powerUp = new WeaponUpgrade1(rectangle.x, rectangle.y , game);
				game.addEntity(powerUp);
			}
			game.deadEntity(this, score);
		}	
	}

	public abstract void shoot();

	public void setPos(int x, int y) {
		rectangle.setLocation(x, y);
	}

	public int getDamage() {
		return 0;
	}

	public void setComportamiento(Behaviour behaviour) {
		comportamiento = behaviour;		
	}

	public double getPosOriginalY() {
		return originalY;
	}
}
