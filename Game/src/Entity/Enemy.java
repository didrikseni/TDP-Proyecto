package Entity;

import java.util.Random;
import Animation.Animation;
import Animation.AnimationExplotion_1;
import Animation.AnimationExplotion_2;
import Behaviour.Behaviour;
import Behaviour.DefaultBehaviour;
import Level.FactoryPowerUp;
import Level.PowerUpFactory;
import Main.Game;
import PowerUp.PowerUp;
import Visitor.Visitor;
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
		visitor = new VisitorEnemy();
	}

	@Override
	public void accept(Visitor v) {
		v.visitEnemy(this);
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
			Animation anim;
			if (rnd.nextBoolean()) {
				anim = new AnimationExplotion_1(rectangle.x, rectangle.y);
			} else {
				anim = new AnimationExplotion_2(rectangle.x, rectangle.y);
			}
			anim.getStarted();
			game.addDeadEntity(this, score);
			game.substractEnemyCount();
			life = -1;
		}
	}

	protected void dropPowerUp() {
		PowerUpFactory factory = new FactoryPowerUp(); 
		PowerUp pw = null;
		int i = rnd.nextInt(100);
		if ( i < 15 ) {
			pw = factory.getPotion(rectangle.x, rectangle.y, game);
		} else if ( i < 20 ) {
			pw = factory.getWeapon(rectangle.x, rectangle.y, game);
		} else if ( i < 26) {
			pw = factory.getWeapon2(rectangle.x, rectangle.y, game);
		} else if ( i < 31 ) {
			pw = factory.getShield(rectangle.x, rectangle.y, game);
		} else if ( i < 37 ) {
			pw = factory.getShield2(rectangle.x, rectangle.y, game);
		} else if ( i < 38 ) {
			pw = factory.getMissile(rectangle.x, rectangle.y, game);
		} else if ( i < 39 ) {
			pw = factory.getFreeze(rectangle.x, rectangle.y, game);
		} else if ( i < 40 ) { 
			pw = factory.getShieldInvunerable(rectangle.x, rectangle.y, game);
		}
		if ( pw != null ) {
			game.addEntity(pw);
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