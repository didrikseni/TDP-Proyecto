package Entity;

import java.util.Random;
import Animation.Animation;
import Animation.AnimationExplotion_1;
import Animation.AnimationExplotion_2;
import Behaviour.Behaviour;
import Behaviour.DefaultBehaviour;
import Main.Game;
import PowerUp.*;

public abstract class Enemy extends Entity {
	protected Behaviour comportamiento;
	protected int originalY, score;
	protected Random rnd;

	protected Enemy(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
		originalY = y;
		comportamiento = DefaultBehaviour.getInstance();
		rnd = new Random();
	}

	public void update() {
		this.updateGraphics();
		comportamiento.update(this);
	}

	@Override
	public void takeDamage(int damage) {
		if (life > 0) {
			life -= damage; 
			if(life < 0) {
				life = 0;
			}
		}
		if(life == 0) {
			dropPowerUp();
			game.addDeadEntity(this, score);
			Animation anim;
			if (rnd.nextBoolean()) {
				anim = new AnimationExplotion_1(rectangle.x, rectangle.y);
				//SoundMananger.playSound("mind_blow_1.wav");
			} else {
				anim = new AnimationExplotion_2(rectangle.x, rectangle.y);
				//SoundMananger.playSound("mind_blow_2.wav");
			}
			anim.getStarted();
			game.substractEnemyCount();
			life = -1;
		}
	}

	protected void dropPowerUp() {
		int i = rnd.nextInt(100);
		PowerUp powerUp = null;
		if (i < 6) {
			powerUp = new PowerUpWeapon_1(rectangle.x, rectangle.y , game);
		} else if (i < 10 && !ThreadFreeze.isRunning()) {
			if (!PowerUpFreeze.hasInstance())
				powerUp = PowerUpFreeze.getInstance(rectangle.x, rectangle.y , game);
		} else if (i < 20) {
			powerUp = new PowerUpPotion(rectangle.x, rectangle.y , game);
		} else if (i < 27) {
			powerUp = new PowerUpShield(rectangle.x, rectangle.y , game);
		} else if (i < 32) {
			powerUp = new PowerUpWeapon_2(rectangle.x, rectangle.y, game);
		} else if (i < 35) {
			powerUp = new PowerUpShield2(rectangle.x, rectangle.y, game);
		} else if (i < 36) {
			powerUp = new PowerUpShieldInvunerable(rectangle.x, rectangle.y, game);
		} else if (i < 37) {
			powerUp = new PowerUpMissile(rectangle.x, rectangle.y, game); 
		}
		if (powerUp != null) {
			game.addEntity(powerUp); 
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

	public Behaviour getBehaviour() {
		return comportamiento;
	}
}
