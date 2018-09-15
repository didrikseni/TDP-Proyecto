package Shot;

import Game.Game;
import Visitor.Visitor;

public class EnemyShot extends Shot {

	public EnemyShot(int x, int y, Game g) {
		super(x, y, g);
	}

	@Override
	public void accept(Visitor v) {
		v.visitEnemyShot(this);
	}

}
