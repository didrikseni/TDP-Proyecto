package Visitor;

import Entity.Enemy;
import Entity.Entity;
import Entity.Player;
import Obstacles.Barricade;
import Obstacles.Destroyable;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public class VisitorObstacleDestroyable extends Visitor {
	private Destroyable obstacle;
	
	public VisitorObstacleDestroyable(Destroyable obstacle) {
		this.obstacle = obstacle;
	}

	public void visitPlayer(Player p) {
		//System.out.println("COLISION DE OBSTACULO DESTRUIBLE CON PLAYER");
	}

	public void visitEnemy(Enemy e) {
		e.takeDamage(0);
		//System.out.println("COLISION DE OBSTACULO DESTRUIBLE CON ENEMIGO");
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
