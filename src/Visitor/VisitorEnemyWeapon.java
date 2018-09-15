package Visitor;

import Entity.Enemy;
import Entity.Entity;
import Entity.Player;
import Obstacles.Barricade;
import Obstacles.Destroyable;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public class VisitorEnemyWeapon extends Visitor {

	public VisitorEnemyWeapon(Entity e) {
		super(e);
	}

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
		System.out.print("Colisiono con disparo enemigo");
	}

	public void visitEnemyShot(EnemyShot e) {
		
	}
	
}
