package Entity;

import java.util.Random;
import Animation.Animation;
import Animation.AnimationExplotion_1;
import Animation.AnimationExplotion_2;
import Behaviour.Behaviour;
import Behaviour.DefaultBehaviour;
import Level.ConcretePowerUpFactory;
import Level.PowerUpFactory;
import Main.Game;
import PowerUp.PowerUp;
import Visitor.VisitorEnemy;

public abstract class Enemy extends Entity {
	protected Behaviour comportamiento;
	protected int originalY, score;
	protected Random rnd;

	protected Enemy(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
		originalY = y;
		comportamiento = DefaultBehaviour.getInstance();
		rnd = new Random();
		visitor = new VisitorEnemy(this);
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
			} else {
				anim = new AnimationExplotion_2(rectangle.x, rectangle.y);
			}
			anim.getStarted();
			game.substractEnemyCount();
			life = -1;
		}
	}

	protected void dropPowerUp() {
		PowerUpFactory factory = new ConcretePowerUpFactory();
		PowerUp powerUp = null;
		if (rnd.nextInt(100) < 40)
			powerUp = factory.getPowerUp(rectangle.x, rectangle.y, game);
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