package Entity;

import Behaviour.DizzyBehaviour;
import Main.Game;
import Visitor.Visitor;

public class EnemyDizzy extends Enemy {

	public EnemyDizzy(int x, int y, int speed, Game g) {
		super(x, y, speed, g);
		comportamiento = new DizzyBehaviour();
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
