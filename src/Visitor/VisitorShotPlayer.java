package Visitor;

import Entity.Enemy;
import Entity.Player;
import Obstacles.Barricade;
import Obstacles.Destroyable;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;
import Shot.Shot;

public class VisitorShotPlayer extends Visitor {
	
	public void visitPlayer(Player p) {
		
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
		
	}

	public void visitEnemyShot(EnemyShot e) {
		
	}
	
}
