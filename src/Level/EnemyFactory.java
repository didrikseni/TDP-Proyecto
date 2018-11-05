package Level;

import Entity.Enemy;
import Main.Game;
import Obstacle.Obstacle;

public abstract class EnemyFactory {
	protected Game game;
	
	public EnemyFactory(Game game) {
		this.game = game;
	}
	
	public abstract Enemy getFinalBoss(int x, int y);
	public abstract Enemy getEnemyWeapon(int x, int y);
	public abstract Enemy getEnemyKamikaze(int x, int y);
	public abstract Enemy getEnemyTracker(int x, int y);
	public abstract Obstacle getDestroyable(int x, int y);
	public abstract Obstacle getBarricade(int x, int y);
	
}
