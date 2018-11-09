package Obstacle;

import Entity.Entity;
import Main.Game;
import Visitor.Visitor;

public abstract class Obstacle extends Entity {

	protected Obstacle(int x, int y, Game g) {
		super(x, y, 0, g);
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitObstacle(this);
	}

	
}
