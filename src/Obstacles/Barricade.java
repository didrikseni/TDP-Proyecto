package Obstacles;

import Main.Game;
import Visitor.Visitor;

public class Barricade extends Obstacles {

	protected Barricade(int x, int y, Game g) {
		super(x, y, g);
	}

	@Override
	public void accept(Visitor v) {
		v.visitObstacleBarricade(this);
	}

}
