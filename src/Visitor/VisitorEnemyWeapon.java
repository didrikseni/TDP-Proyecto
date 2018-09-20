package Visitor;

import Entity.Enemy;
import Entity.EnemyWeapon;
import Entity.Player;
import Obstacles.Barricade;
import Obstacles.Destroyable;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public class VisitorEnemyWeapon extends Visitor {
	private EnemyWeapon enemy;
	
	public VisitorEnemyWeapon(EnemyWeapon e) {
		enemy = e;
	}

	public void visitPlayer(Player p) {
		
	}

	public void visitEnemy(Enemy e) {
		
	}

	public void visitObstacleDestroyable(Destroyable d) {
		d.takeDamage(enemy.getLife());
	}

	public void visitObstacleBarricade(Barricade b) {
		
	}

	public void visitPowerUp(PowerUp p) {
		
	}

	public void visitPlayerShot(PlayerShot p) {
	
	}

	public void visitEnemyShot(EnemyShot e) {
		
	}
	
}
