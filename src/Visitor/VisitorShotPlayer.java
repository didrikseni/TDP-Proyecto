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
	
	public VisitorShotPlayer(Entity e) {
		super(e);
	}

	public void visitPlayer(Player p) {
		
	}

	public void visitEnemy(Enemy e) {
		e.setDamage(25);
		this.e.setDamage(100);
	}

	public void visitObstacleDestroyable(Destroyable d) {
		d.setDamage(25);
		this.e.setDamage(100);
	}

	public void visitObstacleBarricade(Barricade b) {
		b.setDamage(100);
		this.e.setDamage(100);
	}

	public void visitPowerUp(PowerUp p) {
		
	}

	public void visitPlayerShot(PlayerShot p) {
		
	}

	public void visitEnemyShot(EnemyShot e) {
		e.setDamage(100);
		this.e.setDamage(100);
	}
	
}
