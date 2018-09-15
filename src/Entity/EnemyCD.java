package Entity;

import Game.Game;
import Visitor.Visitor;

public class EnemyCD extends Enemy {

	protected EnemyCD(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
