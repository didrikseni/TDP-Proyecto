package Levels;

import Entity.Enemy;
import Entity.EnemyDizzy;
import Entity.EnemyKamikaze;
import Entity.EnemyKamikazeDizzy;
import Entity.EnemyWeaponKamikaze;
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
	public Enemy getEnemyWeapon() {
		return new EnemyWeapon(0,0,1,game);
	}

	@Override
	public Enemy getEnemyChase() {
		return new EnemyKamikaze(0,0,1, game);
	}

	@Override
	public Enemy getEnemyDizzy() {
		return new EnemyKamikazeDizzy(0,0,1, game);
	}

	@Override
	public Enemy getEnemyHybrid() {
		return new EnemyWeaponKamikaze(0,0,1, game);
	}

	@Override
	public Enemy getEnemyCD() {
		return new EnemyDizzy(0,0,1, game);
	}
	
	public Obstacle getDestroyable() {
		return new Destroyable(0,0, game);
	}
	
	public Obstacle getBarricade() {
		return new Barricade(0,0, game);
	}

}
