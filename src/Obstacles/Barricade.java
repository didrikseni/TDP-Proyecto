package Obstacles;

import Main.Game;
import Visitor.Visitor;

public class Barricade extends Obstacle {

	public Barricade(int x, int y, Game g) {
		super(x, y, g);
	}

	@Override
	public void accept(Visitor v) {
		v.visitObstacle(this);
	}

}
