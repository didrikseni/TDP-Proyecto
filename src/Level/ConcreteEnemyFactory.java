package Level;

import Entity.Enemy;
import Entity.EnemyDizzy;
import Entity.EnemyKamikaze;
import Entity.EnemyWeapon;
import Entity.FinalBoss;
import Main.Game;
import Obstacle.Barricade;
import Obstacle.Destroyable;
import Obstacle.Obstacle;

public class ConcreteEnemyFactory extends EnemyFactory {

	public ConcreteEnemyFactory(Game game) {
		super(game);
	}

	@Override
	public Enemy getEnemyWeapon(int x, int y) {
		return new EnemyWeapon(x,y,1,game);
	}

	@Override
	public Enemy getEnemyKamikaze(int x, int y) {
		return new EnemyKamikaze(x,y,1, game);
	}

	@Override
	public Enemy getEnemyDizzy(int x, int y) {
		return new EnemyDizzy(x,y,1, game);
	}
	
	@Override
	public Obstacle getDestroyable(int x, int y) {
		return new Destroyable(x,y, game);
	}
	
	@Override
	public Obstacle getBarricade(int x, int y) {
		return new Barricade(x,y, game);
	}

	@Override
	public Enemy getFinalBoss(int x, int y) {
		return new FinalBoss(x,y,game);
	}

}
