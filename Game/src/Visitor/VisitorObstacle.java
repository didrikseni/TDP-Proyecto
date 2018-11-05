package Visitor;

import Entity.Enemy;
import Entity.Player;
import Obstacle.Obstacle;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public class VisitorObstacle extends Visitor {
	protected Obstacle obstacle;
	
	public VisitorObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public void visitPlayer(Player p) {
		
	}

	public void visitEnemy(Enemy e) {
		obstacle.takeDamage(e.getLife());
		e.takeDamage(e.getLife() / 2);
	}

	public void visitObstacle(Obstacle b) {
		
	}

	public void visitPowerUp(PowerUp p) {
		
	}

	public void visitPlayerShot(PlayerShot p) {
		
	}

	public void visitEnemyShot(EnemyShot e) {
		obstacle.takeDamage(e.getDamage());
		e.takeDamage(e.getLife());
	}
	
}
