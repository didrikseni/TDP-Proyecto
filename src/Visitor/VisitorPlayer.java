package Visitor;

import Entity.Enemy;
import Entity.Player;
import Obstacles.Barricade;
import Obstacles.Destroyable;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public class VisitorPlayer extends Visitor{
	private Player player;
	
	public VisitorPlayer(Player e) {
		player = e;
	}

	public void visitPlayer(Player p) {}

	public void visitEnemy(Enemy e) {
		e.takeDamage(player.getLife());
		player.takeDamage(player.getLife());
	}

	public void visitObstacleDestroyable(Destroyable d) {
		//player.takeDamage(player.getLife());
	}

	public void visitObstacleBarricade(Barricade b) {
		//player.takeDamage(player.getLife());
	}

	public void visitPowerUp(PowerUp p) {
		p.addPowerUp(player);
	}

	public void visitPlayerShot(PlayerShot p) {}

	public void visitEnemyShot(EnemyShot e) {
		e.takeDamage(e.getLife());
		player.takeDamage(e.getDamage());
	}

}
