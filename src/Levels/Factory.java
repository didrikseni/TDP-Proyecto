package Levels;

import Entity.Enemy;
import Main.Game;
import Obstacles.Obstacle;

public abstract class Factory {
	protected Game game;
	
	public Factory(Game game) {
		this.game = game;
	}
	
	public abstract Enemy getEnemyWeapon();
	public abstract Enemy getEnemyChase();
	public abstract Enemy getEnemyDizzy();
	public abstract Enemy getEnemyHybrid();
	public abstract Enemy getEnemyCD();
	public abstract Obstacle getDestroyable();
	public abstract Obstacle getBarricade();
	
}
