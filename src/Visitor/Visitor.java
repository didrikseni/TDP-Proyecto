package Visitor;

import Entity.Enemy;
import Entity.Player;
import Obstacles.Barricade;
import Obstacles.Destroyable;
import PowerUp.PowerUp;
import Shot.EnemyShot;
import Shot.PlayerShot;

public abstract class Visitor {
	
	//Commands
	public abstract void visitPlayer(Player p);
	public abstract void visitEnemy(Enemy e);
	public abstract void visitObstacleDestroyable(Destroyable d);
	public abstract void visitObstacleBarricade(Barricade b);
	public abstract void visitPowerUp(PowerUp p);
	public abstract void visitPlayerShot(PlayerShot p);
	public abstract void visitEnemyShot(EnemyShot e);
	
}
