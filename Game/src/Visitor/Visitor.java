package Visitor;

import Entity.Enemy;
import Entity.Player;
import Obstacle.Obstacle;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public abstract class Visitor {
	//Commands
	public abstract void visitPlayer(Player p);
	public abstract void visitEnemy(Enemy e);
	public abstract void visitObstacle(Obstacle d);
	public abstract void visitPowerUp(PowerUp p);
	public abstract void visitPlayerShot(PlayerShot p);
	public abstract void visitEnemyShot(EnemyShot e);
	
}
