package Levels;

import Entity.Enemy;
import Main.Game;
import Obstacles.Obstacle;

public abstract class Factory {
	protected Game game;
	
	public Factory(Game game) {
		this.game = game;
	}
	
	public abstract Enemy getEnemyWeapon(int x, int y);
	public abstract Enemy getEnemyChase(int x, int y);
	public abstract Enemy getEnemyDizzy(int x, int y);
	public abstract Enemy getEnemyHybrid(int x, int y);
	public abstract Enemy getEnemyCD(int x, int y);
	public abstract Obstacle getDestroyable(int x, int y);
	public abstract Obstacle getBarricade(int x, int y);
	
}
