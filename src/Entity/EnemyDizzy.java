package Entity;

import Game.Game;
import Visitor.Visitor;

public class EnemyDizzy extends Enemy {

	protected EnemyDizzy(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

}
