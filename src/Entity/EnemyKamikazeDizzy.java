package Entity;

import Behaviour.DizzyBehaviour;
import Behaviour.KamikazeBehaviour;
import Main.Game;
import PowerUp.PowerUp;
import PowerUp.WeaponUpgrade1;
import Visitor.Visitor;

public class EnemyKamikazeDizzy extends Enemy {

	public EnemyKamikazeDizzy(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
		comportamiento = new KamikazeBehaviour();
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
				PowerUp powerUp = new WeaponUpgrade1(rectangle.x, rectangle.y, game);
				game.addEntity(powerUp);
			}
			game.deadEntity(this, score);
		} else if (life <= 50) {
			comportamiento = new DizzyBehaviour();
		}		
	}

}
