package Level;

import Entity.Enemy;
import Entity.EnemyDizzy;
import Entity.EnemyKamikaze;
import Entity.EnemyWeapon;
import Main.Game;
import Obstacles.Barricade;
import Obstacles.Destroyable;
import Obstacles.Obstacle;

public class ConcreteFactory extends Factory {

	public ConcreteFactory(Game game) {
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
	
	public Obstacle getDestroyable(int x, int y) {
		return new Destroyable(x,y, game);
	}
	
	public Obstacle getBarricade(int x, int y) {
		return new Barricade(x,y, game);
	}

}
