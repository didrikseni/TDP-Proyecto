package Entity;

import java.util.Random;

import Animation.Animation;
import Animation.AnimationExplotion_1;
import Animation.AnimationExplotion_2;
import Behaviour.Behaviour;
import Behaviour.DefaultBehaviour;
import Main.Game;

public abstract class Enemy extends Entity {
	//Attributes
	protected Behaviour comportamiento;
	protected int score;
	protected int originalY;
	protected Random rnd;
	
	protected Enemy(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
		originalY = y;
		comportamiento = DefaultBehaviour.getInstance();
		rnd = new Random();
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
			dropPowerUp();
			game.addDeadEntity(this, score);
			Animation anim;
			if (rnd.nextBoolean()) {
				anim = new AnimationExplotion_1(rectangle.x, rectangle.y);
			} else {
				anim = new AnimationExplotion_2(rectangle.x, rectangle.y);
			}
			anim.getStarted();
			game.substractEnemyCount();
		}	
	}

	protected abstract void dropPowerUp();

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

	public Behaviour getBehaviour() {
		return comportamiento;
	}
}
