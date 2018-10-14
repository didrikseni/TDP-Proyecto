package Visitor;

import Entity.Enemy;
import Entity.Player;
import Obstacles.Obstacle;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public class VisitorEnemy extends Visitor {
	private Enemy enemy;
	
	public VisitorEnemy (Enemy e) { 
		enemy = e;
	}

	@Override
	public void visitPlayer(Player p) {
		
	}

	@Override
	public void visitEnemy(Enemy e) {}

	@Override
	public void visitPowerUp(PowerUp p) {
			
	}

	@Override
	public void visitPlayerShot(PlayerShot p) {
		enemy.takeDamage(p.getDamage());
		p.takeDamage(p.getLife());
	}

	@Override
	public void visitEnemyShot(EnemyShot e) {
		
	}

	@Override
	public void visitObstacle(Obstacle d) {
		
	}

}
