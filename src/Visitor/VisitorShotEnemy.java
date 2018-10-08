package Visitor;

import Entity.Enemy;
import Entity.Player;
import Obstacles.Obstacle;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;
import Shot.Shot;

public class VisitorShotEnemy extends Visitor {
	private Shot shot;
	
	public VisitorShotEnemy(EnemyShot enemyShot) {
		shot = enemyShot;
	}

	public void visitPlayer(Player p) {
		
	}

	public void visitEnemy(Enemy e) {
		
	}

	public void visitPowerUp(PowerUp p) {
		
	}

	public void visitPlayerShot(PlayerShot p) {
		
	}

	public void visitEnemyShot(EnemyShot e) {
		
	}

	@Override
	public void visitObstacle(Obstacle d) {
		d.takeDamage(shot.getDamage());
		shot.takeDamage(shot.getLife());
	}	
	
}
