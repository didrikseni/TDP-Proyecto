package Visitor;

import Animation.Animation;
import Animation.AnimationSparkEnemy;
import Entity.Enemy;
import Entity.Player;
import Obstacle.Obstacle;
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
		Animation anm = new AnimationSparkEnemy(e.getPos().x, e.getPos().y - (e.getHeight() / 2));
		anm.getStarted();
		e.takeDamage(playerShot.getDamage());
		playerShot.takeDamage(playerShot.getLife());		
	}

	public void visitPowerUp(PowerUp p) {
		
	}

	public void visitPlayerShot(PlayerShot p) {
		
	}

	public void visitEnemyShot(EnemyShot e) {}

	@Override
	public void visitObstacle(Obstacle o) {
		o.takeDamage(playerShot.getDamage());
		playerShot.takeDamage(playerShot.getLife());
	}
	
}
