package Visitor;

import Entity.Enemy;
import Entity.Entity;
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
		player.takeDamage(player.getLife());
		System.out.println("COLISION CON OBSTACULO DESTRUIBLE");
	}

	public void visitObstacleBarricade(Barricade b) {
		player.takeDamage(player.getLife());
		System.out.println("COLISION CON OBSTACULO BARRICADA");
	}

	public void visitPowerUp(PowerUp p) {
		
	}

	public void visitPlayerShot(PlayerShot p) {}

	public void visitEnemyShot(EnemyShot e) {		
		player.takeDamage(e.getDamage());
	}

}
