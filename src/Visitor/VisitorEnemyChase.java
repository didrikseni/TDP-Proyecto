package Visitor;

import Entity.Enemy;
import Entity.EnemyChase;
import Entity.Player;
import Obstacles.Barricade;
import Obstacles.Destroyable;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public class VisitorEnemyChase extends Visitor {
	private Enemy enemy;
	
	public VisitorEnemyChase(Enemy enemy) {
		this.enemy = enemy;
	}

	public void visitPlayer(Player p) {
		p.takeDamage(enemy.getDamage());
		enemy.takeDamage(enemy.getLife());
	}

	public void visitEnemy(Enemy e) {
		
	}

	public void visitObstacleDestroyable(Destroyable d) {
		
	}

	public void visitObstacleBarricade(Barricade b) {
		
	}

	public void visitPowerUp(PowerUp p) {
		
	}

	public void visitPlayerShot(PlayerShot p) {
		enemy.takeDamage(p.getDamage());
		p.takeDamage(p.getLife());
	}

	public void visitEnemyShot(EnemyShot e) {
		
	}
	
}
