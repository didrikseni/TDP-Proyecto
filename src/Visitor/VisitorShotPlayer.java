package Visitor;

import Entity.Enemy;
import Entity.Entity;
import Entity.Player;
import Obstacles.Barricade;
import Obstacles.Destroyable;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public class VisitorShotPlayer extends Visitor {
	private PlayerShot playerShot;	
	
	public VisitorShotPlayer(PlayerShot playerShot) {
		this.playerShot = playerShot;
	}

	public void visitPlayer(Player p) {
		
	}

	public void visitEnemy(Enemy e) {
		e.takeDamage(playerShot.getDamage());
		playerShot.takeDamage(playerShot.getLife());
	}

	public void visitObstacleDestroyable(Destroyable d) {
		d.takeDamage(playerShot.getDamage());
		playerShot.takeDamage(playerShot.getLife());
	}

	public void visitObstacleBarricade(Barricade b) {
		b.takeDamage(playerShot.getDamage());
		playerShot.takeDamage(playerShot.getLife());
	}

	public void visitPowerUp(PowerUp p) {
		
	}

	public void visitPlayerShot(PlayerShot p) {
		
	}

	public void visitEnemyShot(EnemyShot e) {}
	
}
