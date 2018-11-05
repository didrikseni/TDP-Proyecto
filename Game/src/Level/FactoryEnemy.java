package Level;

import Entity.Enemy;
import Entity.EnemyKamikaze;
import Entity.EnemyWeapon;
import Entity.EnemyTracker;
import Entity.FinalBoss;
import Main.Game;
import Obstacle.Barricade;
import Obstacle.Destroyable;
import Obstacle.Obstacle;

public class FactoryEnemy extends EnemyFactory {

	public FactoryEnemy(Game game) {
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

	@Override
	public Enemy getEnemyTracker(int x, int y) {
		return new EnemyTracker(x, y, 1,game);
	}

}
