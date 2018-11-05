package Behaviour;

import Entity.Enemy;

public class FreezeBehaviour extends Behaviour {
	private static FreezeBehaviour INSTANCE;
	
	public static FreezeBehaviour getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new FreezeBehaviour();
		}
		return INSTANCE;
	}
	
	public void update(Enemy e) {
		
	}

	@Override
	public void changeBehaviour(Enemy enemy) {}

	
}
