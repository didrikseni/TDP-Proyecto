package Visitor;

import Entity.Enemy;
import Entity.Player;
import Obstacles.Barricade;
import Obstacles.Destroyable;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public class VisitorPowerUp extends Visitor {
	private PowerUp powerUp;
	
	public VisitorPowerUp(PowerUp pw) {
		powerUp = pw;
	}
	
	@Override
	public void visitPlayer(Player p) {
		
	}

	@Override
	public void visitEnemy(Enemy e) {
		
	}

	@Override
	public void visitObstacleDestroyable(Destroyable d) {
		
	}

	@Override
	public void visitObstacleBarricade(Barricade b) {
		
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

}
