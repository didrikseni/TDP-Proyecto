package Visitor;

import Entity.Enemy;
import Entity.Player;
import Obstacles.Barricade;
import Obstacles.Destroyable;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public class VisitorEnemy extends Visitor {
	private Enemy enemy;
	
	public VisitorEnemy (Enemy e) { 
		enemy = e;
	}

	@Override
	public void visitPlayer(Player p) {
		p.takeDamage(enemy.getDamage());
		enemy.takeDamage(enemy.getLife());		
	}

	@Override
	public void visitEnemy(Enemy e) {}

	@Override
	public void visitObstacleDestroyable(Destroyable d) {
		//enemy.takeDamage(d.getLife());		
		//d.takeDamage(enemy.getDamage());
	}

	@Override
	public void visitObstacleBarricade(Barricade b) {
	}

	@Override
	public void visitPowerUp(PowerUp p) {
			
	}

	@Override
	public void visitPlayerShot(PlayerShot p) {
		enemy.takeDamage(p.getDamage());
		p.takeDamage(p.getLife());
	}

	@Override
	public void visitEnemyShot(EnemyShot e) {
		
	}

}
