package Visitor;

import Entity.Enemy;
import Entity.Player;
import Obstacles.Obstacle;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public class VisitorPowerUp extends Visitor {
	
	public VisitorPowerUp(PowerUp pw) {

	}
	
	@Override
	public void visitPlayer(Player p) {
		
	}

	@Override
	public void visitEnemy(Enemy e) {
		
	}

	@Override
	public void visitPowerUp(PowerUp p) {
		
	}

	@Override
	public void visitPlayerShot(PlayerShot p) {
		
	}

	@Override
	public void visitEnemyShot(EnemyShot e) {
		
	}

	@Override
	public void visitObstacle(Obstacle d) {
		
	}

}
