package Entity;

import Behaviour.KamikazeBehaviour;
import Main.Game;
import PowerUp.PowerUp;
import PowerUp.WeaponUpgrade1;
import Visitor.Visitor;

public class EnemyWeaponKamikaze extends Enemy {

	public EnemyWeaponKamikaze(int x, int y, int speed,  Game g) {
		super(x, y, speed, g);
	}

	@Override
	public void accept(Visitor v) {		
	}

	@Override
	public void shoot() {		
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
			game.deadEntity(this, score);
		} else if (life <= 25) {
			comportamiento = new KamikazeBehaviour();
		}		
	}
}
