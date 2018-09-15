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

	public VisitorPlayer(Entity e) {
		super(e);
	}

	public void visitPlayer(Player p) {}

	public void visitEnemy(Enemy e) {
		e.setDamage(100);
		this.e.setDamage(50);
		//System.out.println("COLISION CON ENEMIGO");
	}

	public void visitObstacleDestroyable(Destroyable d) {
		System.out.println("COLISION CON OBSTACULO DESTRUIBLE");
	}

	public void visitObstacleBarricade(Barricade b) {
		System.out.println("COLISION CON OBSTACULO BARRICADA");
	}

	public void visitPowerUp(PowerUp p) {
		
	}

	public void visitPlayerShot(PlayerShot p) {}

	public void visitEnemyShot(EnemyShot e) {		
		
	}

}
