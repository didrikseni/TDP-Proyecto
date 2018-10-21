package Visitor;

import Entity.Enemy;
import Obstacles.Obstacle;
import Shot.EnemyShot;

public class VisitorBarricade extends VisitorObstacle {

	public VisitorBarricade(Obstacle obstacle) {
		super(obstacle);
	}
	
	@Override
	public void visitEnemy(Enemy e) {}
	
	@Override
	public void visitEnemyShot(EnemyShot e) {}

}
